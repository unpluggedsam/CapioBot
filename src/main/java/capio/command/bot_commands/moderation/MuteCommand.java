package capio.command.bot_commands.moderation;

import capio.command.bot_commands.Command;
import capio.command.permission_handle.AdminPermission;
import capio.command.permission_handle.PermissionEnum;
import capio.command.permission_handle.RoleFactory;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Map;

public class MuteCommand implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final Map<Class<? extends Command>, Command> commandList) {

        final Member member = event.getMessage().getMentions().getMembers().get(0);

        // mute role
        final Role role = RoleFactory.createRole(event.getGuild(), 988245680453738546L, "Mute");

        if (member.hasPermission(Permission.ADMINISTRATOR)) {
            event.getGuildChannel().sendMessage("Can't mute an Administrator!").queue();
        } else {
            if(args.length == 3) {
                event.getGuild().addRoleToMember(member, role).queue();
                event.getGuildChannel().sendMessage("Muted " + args[1] + " for " + args[2] + " minute(s)!").queue();

                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                event.getGuild().removeRoleFromMember(member, role).queue();
                                event.getGuildChannel().sendMessage("Unmuted " + args[1]  + "!").queue();
                            }
                        }, Integer.parseInt(args[2]) * 60000
                );
            } else {
                if(!member.getRoles().contains(role)) {
                    event.getGuild().addRoleToMember(member, role).queue();
                    event.getGuildChannel().sendMessage("Muted " + args[1]  + "!").queue();
                } else {
                    event.getGuild().removeRoleFromMember(member, role).queue();
                    event.getGuildChannel().sendMessage("Unmuted " + args[1]  + "!").queue();
                }
            }
        }
    }

    @Override
    public String getCommandName() {
        return "Mute";
    }

    @Override
    public String getDescription() {
        return "Mute a User for a amount of time. First argument is the amount of time the User will be muted for.";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public List<PermissionEnum> getPermissionEnum() {
        return List.of(PermissionEnum.Administrator, PermissionEnum.Moderator);
    }
}
