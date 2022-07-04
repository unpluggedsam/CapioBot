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
    private final Map<Class<? extends Command>, Command> commands = new HashMap();

    public CommandList() {
        try {
            ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
            provider.addIncludeFilter(new AssignableTypeFilter(Command.class));

            Set<BeanDefinition> components = provider.findCandidateComponents("capio/command/bot_commands");
            for (BeanDefinition component : components) {
                try {

                    final Command command = (Command) Class.forName(component.getBeanClassName()).getConstructor().newInstance();

                    if (command.isEnabled()) {
                        commands.put(command.getClass(), command);
                    }

                } catch (IllegalArgumentException | SecurityException ignored) {

                } catch (final ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (final InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (final InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (final IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (final NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
        } finally {

        }
    }

        /**
         * @return A {@link List} of all the {@link Command}'s.
         */
        public Map<Class<? extends Command>, Command> getCommandList() {
            return commands;
        }
    }
