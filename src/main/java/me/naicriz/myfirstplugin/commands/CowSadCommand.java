package me.naicriz.myfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class CowSadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;


        if(!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser ejecutado por un jugador.");
            return true;
        }

        boolean isBaby = false;

        if (args.length == 1 && args[0].equalsIgnoreCase("baby"))
            return isBaby = true;

        // player.getWorld().spawnEntity(player.getLocation(), org.bukkit.entity.EntityType.COW);
        return true;
    }
}
