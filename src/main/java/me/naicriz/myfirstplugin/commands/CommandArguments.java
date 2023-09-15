package me.naicriz.myfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandArguments implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Este comando es para probar los argumentos que se le pueden pasar a un comando.
        // No sé si es lo más eficiente, pero se verá más adelante.
        if (sender instanceof Player player) {
            switch ( args.length ) {
                case 0 -> player.sendMessage("Sin argumentos proporcionados.\n" + ChatColor.AQUA + "/cmdargs <args>");
                case 1 -> player.sendMessage("Argumento proporcionado:" + args.length + " " + args[0]);
                default -> {
                    player.sendMessage("Argumentos proporcionados: " + args.length);
                    for (int i = 0; i < args.length; i++) {
                        player.sendMessage(ChatColor.BOLD + "Argumento " + ChatColor.BOLD + ChatColor.GOLD + i + ChatColor.BOLD + ": " + ChatColor.AQUA + args[i]);
                    }
                }
            }
        }
        return true;
    }
}
