package me.naicriz.myfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestPermCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender; // Cast sender to Player type.

        if (player.hasPermission("MyFirstPlugin.test") && command.getName().equalsIgnoreCase("testperm") || player.isOp()) {
            player.sendMessage("Nais, tienes permisos para ejecutar este comando.");
        } else {
            player.sendMessage("No tienes permisos para ejecutar este comando mai men.");
        }
        return true;
    }
}
