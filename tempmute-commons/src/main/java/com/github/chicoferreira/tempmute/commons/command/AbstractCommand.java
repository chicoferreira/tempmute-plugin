package com.github.chicoferreira.tempmute.commons.command;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.command.Command;
import com.github.chicoferreira.tempmute.mute.MuteService;
import com.github.chicoferreira.tempmute.user.UserService;

public abstract class AbstractCommand implements Command {

    private final String name;
    private final TempmutePlugin plugin;

    public AbstractCommand(String name, TempmutePlugin plugin) {
        this.name = name;
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return name;
    }

    public TempmutePlugin getPlugin() {
        return plugin;
    }

    public UserService getUserService() {
        return plugin.getUserService();
    }

    public MuteService getMuteService() {
        return plugin.getMuteService();
    }
}
