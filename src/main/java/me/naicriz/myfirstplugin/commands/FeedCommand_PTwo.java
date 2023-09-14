package me.naicriz.myfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand_PTwo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Feed - Rellena la barra de hambre del jugador que ejecuta el comando.
        if (sender instanceof Player player) {

            if (player.getFoodLevel() != 20) {
                player.setFoodLevel(20);
                player.sendMessage(ChatColor.GOLD + "Te has alimentado, ahora estás satisfecho.");
            } else {
                player.sendMessage(ChatColor.RED + "Ya estás satisfecho.");
            }
        }
        return true;
    }
}
