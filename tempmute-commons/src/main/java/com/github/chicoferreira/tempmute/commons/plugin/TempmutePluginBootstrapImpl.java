package com.github.chicoferreira.tempmute.commons.plugin;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.commons.mute.MuteServiceImpl;
import com.github.chicoferreira.tempmute.commons.user.UserServiceImpl;
import com.github.chicoferreira.tempmute.plugin.TempmutePluginBootstrap;

import java.util.HashMap;

public class TempmutePluginBootstrapImpl implements TempmutePluginBootstrap {

    private TempmutePluginImpl plugin;

    @Override
    public void enable() {
        plugin.userService = new UserServiceImpl();
        plugin.muteService = new MuteServiceImpl(new HashMap<>()/* TODO: Database connection*/);
    }

    @Override
    public void disable() {

    }

}
