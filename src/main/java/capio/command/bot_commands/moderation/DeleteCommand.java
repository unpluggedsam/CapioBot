package capio.command.bot_commands.moderation;

import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import capio.command.permission_handle.PermissionEnum;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

/**
 * Deletes a certain amount of messages
 */
public class DeleteCommand implements Command {

    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final GuildCommandsHandler guildCommandsHandler) {
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
    public List<PermissionEnum> getPermissionEnum() {
        return List.of(PermissionEnum.ADMIN, PermissionEnum.MODERATOR);
    }

    @Override
    public String getDescription() {
        return "Deletes a given amount of messages from a channel. First argument is the amount of messages that are to be deleted. Provided number must be between 1 and 100.";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
