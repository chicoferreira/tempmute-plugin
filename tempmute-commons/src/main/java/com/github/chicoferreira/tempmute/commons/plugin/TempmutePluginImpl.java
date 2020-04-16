package com.github.chicoferreira.tempmute.commons.plugin;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.commons.mute.MuteServiceImpl;
import com.github.chicoferreira.tempmute.commons.user.AbstractUserService;

public class TempmutePluginImpl implements TempmutePlugin {

    MuteServiceImpl muteService;
    AbstractUserService userService;

    @Override
    public MuteServiceImpl getMuteService() {
        return muteService;
    }

    @Override
    public AbstractUserService getUserService() {
        return userService;
    }

}
