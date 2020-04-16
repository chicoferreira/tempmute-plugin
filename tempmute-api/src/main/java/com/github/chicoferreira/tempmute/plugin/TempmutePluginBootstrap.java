package com.github.chicoferreira.tempmute.plugin;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.command.Command;

import java.util.logging.Logger;

public interface TempmutePluginBootstrap {

    TempmutePlugin getPlugin();

    void enable();

    void disable();

    void registerCommand(Command command);

    Logger getLogger();
}
