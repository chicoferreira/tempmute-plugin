package com.github.chicoferreira.tempmute.commons.plugin;

import com.github.chicoferreira.tempmute.commons.commands.TempmuteCommmand;
import com.github.chicoferreira.tempmute.commons.commands.UnmuteCommand;
import com.github.chicoferreira.tempmute.commons.mute.MuteServiceImpl;
import com.github.chicoferreira.tempmute.plugin.TempmutePluginBootstrap;
import com.github.chicoferreira.tempmute.user.UserService;

import java.util.HashMap;

public abstract class AbstractTempmutePluginBootstrap implements TempmutePluginBootstrap {

    @Override
    public final void enable() {
        TempmutePluginImpl plugin = (TempmutePluginImpl) getPlugin();

        plugin.muteService = new MuteServiceImpl(new HashMap<>()/* TODO: Database connection*/);

        registerCommand(new TempmuteCommmand(plugin));
        registerCommand(new UnmuteCommand(plugin));
    }

    @Override
    public final void disable() {

    }

    @Override
    public final void setUserService(UserService userService) {
        TempmutePluginImpl plugin = (TempmutePluginImpl) getPlugin();
    }
}
