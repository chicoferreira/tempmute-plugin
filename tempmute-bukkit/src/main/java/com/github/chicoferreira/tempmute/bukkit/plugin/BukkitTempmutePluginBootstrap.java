package com.github.chicoferreira.tempmute.bukkit.plugin;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import com.github.chicoferreira.tempmute.command.Command;
import com.github.chicoferreira.tempmute.commons.Constants;
import com.github.chicoferreira.tempmute.commons.plugin.AbstractTempmutePluginBootstrap;
import com.github.chicoferreira.tempmute.commons.plugin.TempmutePluginImpl;
import com.github.chicoferreira.tempmute.user.User;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class BukkitTempmutePluginBootstrap extends AbstractTempmutePluginBootstrap {

    private final JavaPlugin bukkitPlugin;
    private final TempmutePlugin tempmutePlugin;

    public BukkitTempmutePluginBootstrap(JavaPlugin bukkitPlugin) {
        this.bukkitPlugin = bukkitPlugin;
        this.tempmutePlugin = new TempmutePluginImpl();
    }

    @Override
    public TempmutePlugin getPlugin() {
        return tempmutePlugin;
    }

    @Override
    public void registerCommand(Command command) {
        PluginCommand pluginCommand = bukkitPlugin.getCommand(command.getName());

        if (pluginCommand == null) {
            getLogger().warning("Couldn't register /" + command.getName() + ". Is it on plugin.yml?");
            return;
        }

        pluginCommand.setExecutor((commandSender, bukkitCommand, label, args) -> {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(Constants.COMMAND_ONLY_PLAYERS);
                return false;
            }

            User user = tempmutePlugin.getUserService().getUserByEntity((Player) commandSender);
            command.execute(user, args);
            return true;
        });
    }

    @Override
    public Logger getLogger() {
        return bukkitPlugin.getLogger();
    }
}
