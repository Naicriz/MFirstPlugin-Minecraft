package me.naicriz.myfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class FartCommand implements CommandExecutor {

    // fart <playerName> <fartType> ?
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {

            if (args.length == 0) {
                player.sendMessage("Eres asqueroso. Te cagaste encima y moriste a causa de ello.");
                player.setHealth(0.0);
            } else {
                String playerName = args[0]; // "naicriz"
                Player targetPlayer = getServer().getPlayerExact(playerName); // Player object

                if(targetPlayer == null) {
                    player.sendMessage("El jugador no existe o no está en línea.");
                } else {
                    player.sendMessage("Le has cagado encima a " + targetPlayer.getDisplayName() + ". Te sientes liberado...");
                    targetPlayer.sendMessage(player.getDisplayName() + " te ha cagado encima" + " Cómo se siente?");
                    targetPlayer.setHealth(0.0);
                }
            }
        }
        return true;
    }
}
