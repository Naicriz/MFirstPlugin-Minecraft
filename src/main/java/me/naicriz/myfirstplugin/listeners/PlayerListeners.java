package me.naicriz.myfirstplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        System.out.println("Un jugador ha ingresado al servidor.");
        event.setJoinMessage("Bienvenido al servidor, " + event.getPlayer().getName() + "!");
    }
}
