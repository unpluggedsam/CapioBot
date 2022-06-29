package capio.command_observer;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface CommandExecutedSubject {

    void notifiyObservers(MessageReceivedEvent event);

    void addObserver(CommandExecutedObserver observer);

    void removeObserver(CommandExecutedObserver observer);
}
