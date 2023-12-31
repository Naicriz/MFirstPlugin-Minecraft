package me.naicriz.myfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class DieCommand_PartOne implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Morir - Mata al jugador que ejecuta el comando.
        if (command.getName().equalsIgnoreCase("die")) {

            if (sender instanceof Player player) {
                player.setHealth(0.0);
                player.sendMessage(ChatColor.RED + "Has optado por la muerte.");
            } else if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage(ChatColor.RED + "Solo los jugadores pueden ejecutar este comando.");
            }
        }
    return true;
    }
}