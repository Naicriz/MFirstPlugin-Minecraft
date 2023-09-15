package me.naicriz.myfirstplugin.listeners;

import me.naicriz.myfirstplugin.MyFirstPlugin_MC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    // Método 2 - Inyección de constructor
    // Se crea una variable final de tipo MyFirstPlugin_MC y se le asigna el valor del parámetro del constructor.
    private final MyFirstPlugin_MC pluginMethodTwo;

    // Se crea un constructor que recibe un parámetro de tipo MyFirstPlugin_MC
    // y se le asigna el valor del parámetro a la variable final.
    public DeathListener(MyFirstPlugin_MC pluginMethodTwo) {
        this.pluginMethodTwo = pluginMethodTwo;
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage("El jugador " + event.getEntity().getName() + "ha muerto. RIP PEPERONNI");
    }
}
