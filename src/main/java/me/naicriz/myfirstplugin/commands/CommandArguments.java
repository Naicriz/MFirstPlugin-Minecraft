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
                case 0 -> player.sendMessage(ChatColor.BOLD + "Sin argumentos proporcionados.\n" + ChatColor.AQUA + ChatColor.BOLD + "/cmdargs <args>");
                case 1 -> player.sendMessage(ChatColor.GREEN + "Case 1 | " + ChatColor.WHITE + ChatColor.BOLD + "Argumento proporcionado: " + ChatColor.BOLD + ChatColor.GOLD + args.length + " " + args[0]);
                case 2 -> {
                    String word = args[1];
                    player.sendMessage(ChatColor.GREEN + "Case 2 | " + ChatColor.WHITE + ChatColor.BOLD + "Argumentos proporcionados: " + ChatColor.BOLD + ChatColor.GOLD + args.length);
                    player.sendMessage(ChatColor.BOLD + "Argumento: " + ChatColor.BOLD + ChatColor.GOLD + args.length + ChatColor.AQUA + ChatColor.BOLD + word);
                }
                case 3 -> {
                    player.sendMessage(ChatColor.BOLD + "Argumentos proporcionados: "+ ChatColor.BOLD + ChatColor.GOLD  + args.length);
                    for (int i = 0; i < args.length; i++) {
                        player.sendMessage(ChatColor.BOLD + "Argumento: " + ChatColor.BOLD + ChatColor.GOLD + i + ChatColor.BOLD + ": " + ChatColor.AQUA + args[i]);
                    }
                }
                default -> {
                    StringBuilder strbuilder = new StringBuilder();

                    // for (int i = 0; i < args.length; i++) {
                        // strbuilder.append(args[i]);
                        // strbuilder.append(" ");
                    // }
                    for (String arg : args) {
                        strbuilder.append(arg).append(" ");
                    }
                    // return the strbuilder as a string
                    String str = strbuilder.toString().stripTrailing();
                    player.sendMessage(ChatColor.BOLD + "Este es todo el string: " + ChatColor.BOLD + ChatColor.AQUA + str);

                }
            }
        }
        return true;
    }
}
