package capio.command.bot_commands.hypixel.guild;

import capio.command.bot_commands.Command;

import capio.minecraft.hypixel.guild_statistics.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CurrentGuildLevelCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        Guild guild = new Guild();
        event.getGuildChannel().sendMessage(String.format("The current guild level of %s is %s", args[1], guild.getLevel(args[1]))).queue();
    }

    @Override
    public String getCommandName() {
        return "level";
    }

    @Override
    public String getDescription() {
        return "Gets the current guild level. First argument is the guild name.";
    }
}