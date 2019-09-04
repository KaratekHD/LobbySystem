package com.karatek.lobbysystem.listener;

import com.karatek.lobbysystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getItem().getType() == Material.COMPASS && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.navigator_name) && e.getPlayer().hasMetadata("isinlobby")) {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                Inventory inv = Bukkit.createInventory(null, 9*1, Main.GUI_NAME);
                ItemStack is1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta im1 = is1.getItemMeta();
                im1.setDisplayName("§4§lRPG");
                is1.setItemMeta(im1);
                inv.setItem(3, is1);
                ItemStack is2 = new ItemStack(Material.BED);
                ItemMeta im2 = is2.getItemMeta();
                im2.setDisplayName("§a§lAFK Bereich");
                is2.setItemMeta(im2);
                inv.setItem(5, is2);
                p.openInventory(inv);
            }
        }
        if(e.getItem().getType() == Material.WOOD_DOOR && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.navigatorAdmin_name) && e.getPlayer().hasMetadata("isinlobby")) {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                p.removeMetadata("isinlobby", Main.getInstance());
            }
        }


    }
}
