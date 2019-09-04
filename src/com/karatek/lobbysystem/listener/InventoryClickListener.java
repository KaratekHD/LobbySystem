package com.karatek.lobbysystem.listener;

import com.karatek.lobbysystem.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onGUIInventoryInteract(InventoryClickEvent e) {
        if(!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(Main.GUI_NAME)) {
            e.setCancelled(true);
            switch (e.getCurrentItem().getType()) {
                case DIAMOND_SWORD:
                    p.sendMessage("§aWir verbinden dich zum RPG Server 1...");
                    p.closeInventory();
                    p.removeMetadata("isinlobby", Main.getInstance());
                    break;
                case BED:
                    p.sendMessage("§aWir verbinden dich zum AFK Server 1...");
                    p.closeInventory();
                    break;
                    default:
                        break;
            }
        }
    }

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e) {
        if(!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();
        if(p.hasMetadata("isinlobby") && !p.hasPermission("gamellobby.change")) {
            e.setCancelled(true);
        }


    }
}
