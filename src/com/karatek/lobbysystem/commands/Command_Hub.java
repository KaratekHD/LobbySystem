package com.karatek.lobbysystem.commands;

import com.karatek.lobbysystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class Command_Hub implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("§4Pretty funny, isn't it?");
            return false;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("lobby.hub")) {
            p.sendMessage("§cDazu hast du keine Rechte!");
            return false;
        } else {
            double x = Main.x;
            double y = Main.y;
            double z = Main.z;
            String world = Main.world;
            Location loc = new Location(Bukkit.getWorld(world), x, y, z);
            p.teleport(loc);
            p.setMetadata("isinlobby", new FixedMetadataValue(Main.getInstance(), true));
            //p.getInventory().setItem(4, Main.getInstance().getItemLoader().getNavigator());
            if(p.hasPermission("lobby.admin")) {
                p.getInventory().setItem(2, Main.getInstance().getItemLoader().getNavigator());
                p.getInventory().setItem(6, Main.getInstance().getItemLoader().getNavigatorAdmin());
            } else {
                p.getInventory().setItem(4, Main.getInstance().getItemLoader().getNavigator());
            }
            return true;
        }
    }
}
