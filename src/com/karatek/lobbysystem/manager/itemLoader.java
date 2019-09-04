package com.karatek.lobbysystem.manager;

import com.karatek.lobbysystem.main.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class itemLoader {

    private ItemStack navigator;
    private ItemStack navigatoradmin;

    public void loadItems() {
        ItemStack is = new ItemStack(Material.COMPASS);
        ItemMeta itemMeta = is.getItemMeta();
        itemMeta.setDisplayName(Main.navigator_name);
        is.setItemMeta(itemMeta);
        this.navigator = is;
    }

    public void loadItemsAdmin() {
        ItemStack isa = new ItemStack(Material.WOOD_DOOR);
        ItemMeta itemMetaAdmin = isa.getItemMeta();
        itemMetaAdmin.setDisplayName(Main.navigatorAdmin_name);
        isa.setItemMeta(itemMetaAdmin);
        this.navigatoradmin = isa;
    }

    public ItemStack getNavigator() {
        return navigator;
    }

    public ItemStack getNavigatorAdmin() {
        return navigatoradmin;
    }
}
