package com.github.chicoferreira.tempmute.commons.commands;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.commons.Constants;
import com.github.chicoferreira.tempmute.commons.command.AbstractCommand;
import com.github.chicoferreira.tempmute.commons.util.NumberParser;
import com.github.chicoferreira.tempmute.user.User;

import java.time.Duration;
import java.util.OptionalLong;

public class TempmuteCommmand extends AbstractCommand {

    public TempmuteCommmand(TempmutePlugin plugin) {
        super("tempmute", plugin);
    }

    @Override
    public void execute(User user, String[] args) {
        if (args.length < 2) {
            user.sendMessage(Constants.COMMAND_TEMPMUTE_WRONG_USAGE);
            return;
        }

        String targetName = args[0];
        User target = getUserService().getUserByName(targetName);
        if (target == null) {
            user.sendMessage(Constants.COMMAND_UNKNOWN_TARGET.replace("<target>", targetName));
            return;
        }

        String timeString = args[1];
        OptionalLong optionalTime = NumberParser.parseLong(timeString);
        if (!optionalTime.isPresent()) {
            user.sendMessage(Constants.COMMAND_TEMPMUTE_PARSE_ERROR);
            return;
        }

        long time = optionalTime.getAsLong();

        getMuteService().mute(target, Duration.ofMinutes(time));
        user.sendMessage(Constants.COMMAND_TEMPMUTE_SUCCESS
                .replace("<target>", target.getName())
                .replace("<time>", String.valueOf(time))
        );
    }
}
