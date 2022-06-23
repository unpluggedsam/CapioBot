package capio.command.handle;

import capio.command.bot_commands.Command;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A list of all the {@link Command} Objects that can be used.
 * If a new {@link Command} object is created then all the developer has
 * to do to enable it is add it to the <code>commandList</code> {@link List}.
 */
public class CommandList {

    private CommandList() {

    }

    /**
     *
     * @return A {@link List} of all the {@link Command}'s.
     */
    public static List<Command> getCommandList() {
        final ArrayList<Command> commandList = new ArrayList<>();
        final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AssignableTypeFilter(Resource.class));

        final Set<BeanDefinition> components = provider.findCandidateComponents("com/availaboard/engine/resource");
        for (final BeanDefinition component : components) {
            try {
                final Resource res = (Resource) Class.forName(component.getBeanClassName()).getConstructor().newInstance();
                final ResourceGrid<Resource> grid = new ResourceGrid<>(res.getClass());
                final Grid<Resource> resGrid = grid.loadGrid(res.getClass());
                arr.add(resGrid);

            } catch (final ClassNotFoundException | IllegalAccessException | IllegalArgumentException
                           | InvocationTargetException | SecurityException | InstantiationException
                           | NoSuchMethodException ignored) {

            }
        }
        return Collections.unmodifiableList(commandList);
    }
}
