package com.github.chicoferreira.tempmute.bukkit.user;

import com.github.chicoferreira.tempmute.commons.plugin.TempmutePluginImpl;
import com.github.chicoferreira.tempmute.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UserListener implements Listener {

    private TempmutePluginImpl plugin;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        BukkitUserService userService = (BukkitUserService) plugin.getUserService();
        User user = userService.getUserByName(player.getName());

        if (!(user instanceof BukkitUser)) {
            user = userService.createFor(player);
        }

        ((BukkitUser) user).updatePlayer(player);
    }

}
