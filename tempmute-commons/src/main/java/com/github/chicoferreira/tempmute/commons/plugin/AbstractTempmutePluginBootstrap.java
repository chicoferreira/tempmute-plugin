package com.github.chicoferreira.tempmute.commons.plugin;

import com.github.chicoferreira.tempmute.commons.commands.TempmuteCommmand;
import com.github.chicoferreira.tempmute.commons.commands.UnmuteCommand;
import com.github.chicoferreira.tempmute.commons.mute.MuteServiceImpl;
import com.github.chicoferreira.tempmute.commons.user.UserServiceImpl;
import com.github.chicoferreira.tempmute.plugin.TempmutePluginBootstrap;

import java.util.HashMap;

public abstract class AbstractTempmutePluginBootstrap implements TempmutePluginBootstrap {

    private TempmutePluginImpl plugin;

    @Override
    public TempmutePluginImpl getPlugin() {
        return plugin;
    }

    @Override
    public final void enable() {
        plugin = new TempmutePluginImpl();

        plugin.userService = new UserServiceImpl();
        plugin.muteService = new MuteServiceImpl(new HashMap<>()/* TODO: Database connection*/);

        registerCommand(new TempmuteCommmand(plugin));
        registerCommand(new UnmuteCommand(plugin));
    }

    @Override
    public final void disable() {

    }

}
