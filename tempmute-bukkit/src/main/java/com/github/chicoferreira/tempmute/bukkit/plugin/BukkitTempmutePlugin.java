package com.github.chicoferreira.tempmute.bukkit.plugin;

import com.github.chicoferreira.tempmute.plugin.TempmutePluginBootstrap;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitTempmutePlugin extends JavaPlugin {

    private TempmutePluginBootstrap bootstrap;

    @Override
    public void onEnable() {
        bootstrap = new BukkitTempmutePluginBootstrap(this, bootstrap.getPlugin());
        bootstrap.enable();
    }
}
