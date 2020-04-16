package com.github.chicoferreira.tempmute.bukkit.plugin;

import com.github.chicoferreira.tempmute.TempmutePlugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.chicoferreira.tempmute.commons.TempmutePluginImpl;

public class BukkitTempmutePlugin extends JavaPlugin {

    private TempmutePlugin plugin;

    @Override
    public void onEnable() {
        plugin = new TempmutePluginImpl();
    }
}
