package com.karatek.lobbysystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {

    @EventHandler
    public void onBreak (BlockBreakEvent e) {
        if(e.getPlayer().hasMetadata("isinlobby") && e.getPlayer().getWorld().getName().equals("Hub")) e.setCancelled(true);
    }
}
