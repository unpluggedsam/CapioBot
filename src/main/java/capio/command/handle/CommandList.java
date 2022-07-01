package capio.command.handle;


import capio.command.bot_commands.Command;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * A list of all the {@link Command} Objects that can be used.
 * If a new {@link Command} object is created then all the developer has
 * to do to enable it is add it to the <code>commandList</code> {@link List}.
 */
public class CommandList {

    private CommandList() {

    }



    /**
     * @return A {@link List} of all the {@link Command}'s.
     */
    public static Map<Class<? extends Command>, Command> getCommandList() {
        Map commands = new HashMap<Class<? extends Command>, Command>();
        try {
            final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
            provider.addIncludeFilter(new AssignableTypeFilter(Command.class));

            final Set<BeanDefinition> components = provider.findCandidateComponents("capio/command/bot_commands");
            for (final BeanDefinition component : components) {
                try {

                    Command command = (Command) Class.forName(component.getBeanClassName()).getConstructor().newInstance();

                    if (command.isEnabled()) {
                        commands.put(command.getClass(), command);
                    }

                } catch (final IllegalArgumentException | SecurityException ignored) {

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
            return Collections.unmodifiableMap(commands);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    }
