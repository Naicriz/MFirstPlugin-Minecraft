package me.naicriz.myfirstplugin.commands;

import static me.naicriz.myfirstplugin.MyFirstPlugin_MC.getPlugin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {

            // 1. Obtener la localización del spawn del config.yml.
            Location location = getPlugin().getConfig().getLocation("spawn");

            // 2. Teletransportar al jugador a la localización del spawn si la localización no es nula.
            if (location != null) {
                player.teleport(location);
            } else {
                player.sendMessage("El spawn no ha sido asignado. Usa el comando /setspawn para asignar el spawn.");
            }
        }
        return true;
    }
}
