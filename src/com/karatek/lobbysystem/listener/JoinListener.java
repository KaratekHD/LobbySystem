package com.karatek.lobbysystem.listener;

import com.karatek.lobbysystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class JoinListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Bukkit.getConsoleSender().sendMessage("§r[§6GamelMC§r] " + e.getPlayer().getDisplayName() + "§r signed in on §a" + e.getHostname() + "§r from §a" + e.getAddress() + "§r.");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        p.getInventory().clear();
        p.getInventory().setItem(4, Main.getInstance().getItemLoader().getNavigator());
        p.setMetadata("isinlobby", new FixedMetadataValue(Main.getInstance(), true));
        double x = Main.x;
        double y = Main.y;
        double z = Main.z;
        String world = Main.world;
        Location spawn = new Location(Bukkit.getWorld(world), x, y, z);
        p.teleport(spawn);
    }
}
