package me.naicriz.myfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MenuPlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if(!(sender instanceof Player player)) {
            sender.sendMessage("Only players can execute this command!");
        } else {
            player.sendMessage("Opening menu...");
            openMenu(player);
        }
        return true;
    }

    private void openMenu(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 9, "Personal Menu for " + player.getName());
        

        player.openInventory(inventory);
    }

}
