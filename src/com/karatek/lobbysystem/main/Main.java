package com.karatek.lobbysystem.main;

import com.karatek.lobbysystem.commands.Command_Hub;
import com.karatek.lobbysystem.listener.*;
import com.karatek.lobbysystem.manager.itemLoader;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private final itemLoader itemLoader = new itemLoader();
    private static Main instance;
    public static String navigator_name = "§6Navigator - Rechtsklick!";
    public static String navigatorAdmin_name = "§4LobbySperre ausschalten";
    public static String GUI_NAME = "§6§lNavigator";

    // Spawn Location
    public static double x = 0;
    public static double y = 5;
    public static double z = -35.749;
    public static String world = "Hub";

    @Override
    public void onEnable() {

        instance = this;

        Bukkit.getConsoleSender().sendMessage("§6Das Lobby System wurde aktiviert.");
        itemLoader.loadItems();
        itemLoader.loadItemsAdmin();


        //register commands
        this.getCommand("hub").setExecutor(new Command_Hub());

        //to-do

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new ClickListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);
        //register listener
        //to-do

    }

    public static Main getInstance() {
        return instance;
    }

    public itemLoader getItemLoader() {
        return itemLoader;
    }
}
