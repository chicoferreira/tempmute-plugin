package com.github.chicoferreira.tempmute;

import com.github.chicoferreira.tempmute.mute.MuteService;
import com.github.chicoferreira.tempmute.user.UserService;

public interface TempmutePlugin {

    MuteService getMuteService();

    UserService getUserService();

}
