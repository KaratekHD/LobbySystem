package com.karatek.lobbysystem.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Player) {
            if(((Player) e.getDamager()).getPlayer().hasMetadata("isinlobby")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void on(PlayerDeathEvent e) {
        if(e.getEntity() instanceof Player ) {
            if(e.getEntity().getPlayer().hasMetadata("isinlobby")) {
                e.getEntity().getPlayer().kickPlayer("Wie kann man es schaffen, in der Lobby zu sterben?");
            }
        }

    }
}
