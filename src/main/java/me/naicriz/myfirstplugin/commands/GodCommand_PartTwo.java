package me.naicriz.myfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand_PartTwo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // God - Hace inmortal al jugador que ejecuta el comando.
        if (sender instanceof Player player) {

            if (player.isInvulnerable()) {
                player.setInvulnerable(false);
                player.sendMessage(ChatColor.RED + "Modo dios desactivado.");
            } else {
                player.setInvulnerable(true);
                player.sendMessage(ChatColor.GOLD + "Modo dios activado.");
            }

        }

/*        if (command.getName().equalsIgnoreCase("god")) {

            if (sender.hasPermission("myfirstplugin.god")) {
                sender.sendMessage("Has activado el modo dios.");
            } else {
                sender.sendMessage("No tienes permisos para ejecutar este comando.");
            }
        }*/
        return true;
    }
}
