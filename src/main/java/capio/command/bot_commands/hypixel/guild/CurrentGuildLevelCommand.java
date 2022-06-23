package capio.command.bot_commands.hypixel.guild;

import capio.command.bot_commands.Command;

import capio.minecraft.hypixel.HypixelAPIHelper;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CurrentGuildLevelCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        try {
            event.getGuildChannel().sendMessage(String.format("The current guild level of %s is %s", args[1], HypixelAPIHelper.getGuildLevel(args[1]))).queue();
        } catch(NullPointerException e) {
            event.getGuildChannel().sendMessage(String.format("The guild %s does not exist!", args[1])).queue();
        }

    }

    @Override
    public String getCommandName() {
        return "level";
    }

    @Override
    public String getDescription() {
        return "Gets the current guild level. First argument is the guild name.";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
