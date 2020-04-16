package com.github.chicoferreira.tempmute.plugin;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.command.Command;
import com.github.chicoferreira.tempmute.user.UserService;

import java.util.logging.Logger;

public interface TempmutePluginBootstrap {

    TempmutePlugin getPlugin();

    void enable();

    void disable();

    void registerCommand(Command command);

    void setUserService(UserService userService);

    Logger getLogger();

}
