package capio.command.bot_commands.moderation;

import capio.command.bot_commands.Command;
import capio.command.permission_handle.AdminPermission;
import capio.command.permission_handle.PermissionController;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Deletes a certain amount of messages
 */
public class DeleteCommand implements Command {

    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final Map<Class<? extends Command>, Command> commandList) {
        try {
            event.getGuildChannel().sendMessage(String.format("Attempting to delete %s messsages", args[1])).queue();
            Thread.sleep(200);
            final List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
            event.getGuildChannel().deleteMessages(messages).queue();
        } catch(final IllegalArgumentException e) {
            event.getGuildChannel().sendMessage(String.format(e.getMessage())).queue();
            e.printStackTrace();
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getCommandName() {
        return "delete";
    }

    @Override
    public List<PermissionController> getPermissionController() {
        return List.of(new AdminPermission());
    }

    @Override
    public String getDescription() {
        return "Deletes messages. Enter an integer to specify how many messages you would like to delete.";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
