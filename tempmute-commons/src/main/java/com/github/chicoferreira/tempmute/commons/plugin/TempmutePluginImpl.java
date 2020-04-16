package com.github.chicoferreira.tempmute.commons.plugin;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.mute.MuteService;
import com.github.chicoferreira.tempmute.user.UserService;

public class TempmutePluginImpl implements TempmutePlugin {

    MuteService muteService;
    UserService userService;

    @Override
    public MuteService getMuteService() {
        return muteService;
    }

    @Override
    public UserService getUserService() {
        return userService;
    }

}
