package com.github.chicoferreira.tempmute.commons.commands;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.commons.Constants;
import com.github.chicoferreira.tempmute.commons.command.AbstractCommand;
import com.github.chicoferreira.tempmute.mute.MuteService;
import com.github.chicoferreira.tempmute.user.User;

public class UnmuteCommand extends AbstractCommand {

    public UnmuteCommand(TempmutePlugin plugin) {
        super("unmute", plugin);
    }

    @Override
    public void execute(User user, String[] args) {
        if (args.length < 1) {
            user.sendMessage(Constants.COMMAND_UNMUTE_WRONG_USAGE);
            return;
        }

        String targetName = args[0];
        User target = getUserService().getUserByName(targetName);
        if (target == null) {
            user.sendMessage(Constants.COMMAND_UNKNOWN_TARGET.replace("<target>", targetName));
            return;
        }

        MuteService muteService = getMuteService();
        if (!muteService.isMuted(target)) {
            user.sendMessage(Constants.COMMAND_UNMUTE_TARGET_NOT_MUTED.replace("<target>", target.getName()));
            return;
        }

        muteService.unmute(target);
        user.sendMessage(Constants.COMMAND_UNMUTE_SUCCESS.replace("<target>", target.getName()));
    }
}
