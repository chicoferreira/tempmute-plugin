package com.github.chicoferreira.tempmute.bukkit.user;

import com.github.chicoferreira.tempmute.commons.user.AbstractUser;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class BukkitUser extends AbstractUser<Player> {

    private Player player;

    public BukkitUser(Player player) {
        super(player.getName(), player.getUniqueId(), player);
    }

    @Override
    public void sendMessage(String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public void updatePlayer(Player player) {
        this.player = player;
    }
}
