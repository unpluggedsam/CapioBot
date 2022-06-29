package capio.command_observer;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface CommandExecutedObserver {
    void commandExecuted(MessageReceivedEvent event);
}
