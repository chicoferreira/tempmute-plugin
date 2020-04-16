package com.github.chicoferreira.tempmute.bukkit.plugin;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.command.Command;
import com.github.chicoferreira.tempmute.commons.plugin.AbstractTempmutePluginBootstrap;
import com.github.chicoferreira.tempmute.user.User;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class BukkitTempmutePluginBootstrap extends AbstractTempmutePluginBootstrap {

    private final JavaPlugin bukkitPlugin;
    private final TempmutePlugin tempmutePlugin;

    public BukkitTempmutePluginBootstrap(JavaPlugin bukkitPlugin, TempmutePlugin tempmutePlugin) {
        this.bukkitPlugin = bukkitPlugin;
        this.tempmutePlugin = tempmutePlugin;
    }

    @Override
    public void registerCommand(Command command) {
        PluginCommand pluginCommand = bukkitPlugin.getCommand(command.getName());

        if (pluginCommand == null) {
            getLogger().warning("Couldn't register " + command.getName() + ". Is it on plugin.yml?");
            return;
        }

        pluginCommand.setExecutor((commandSender, bukkitCommand, label, args) -> {
            User user = tempmutePlugin.getUserService().getUserByName(commandSender.getName());
            command.execute(user, args);
            return false;
        });
    }

    @Override
    public Logger getLogger() {
        return bukkitPlugin.getLogger();
    }
}
