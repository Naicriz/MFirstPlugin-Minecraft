package me.naicriz.myfirstplugin.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import static me.naicriz.myfirstplugin.MyFirstPlugin_MC.getPlugin;

public class SpawnListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // 1. Obtener la instancia del jugador que se ha unido.
        Player player = event.getPlayer();

        // 2. Si el jugador no ha jugado antes, teletransportarlo al spawn.
        if (!player.hasPlayedBefore()) {
            Location location = getPlugin().getConfig().getLocation("spawn");

            if (location != null) {
                player.teleport(location);
            } else {
                player.sendMessage("El spawn no ha sido asignado. Usa el comando /setspawn para asignar el spawn.");
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        Location location = getPlugin().getConfig().getLocation("spawn");

        if (location != null ) {
            event.setRespawnLocation(location);
        } else {
            event.getPlayer().sendMessage("El spawn no ha sido asignado. Usa el comando /setspawn para asignar el spawn.");
        }
    }
}
