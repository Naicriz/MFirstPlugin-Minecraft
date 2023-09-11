package me.naicriz.myfirstplugin.listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleBreakListener implements Listener {

    // Cuando el jugador rompe una exp. bottle, se crea una explosión,
    // el efecto visual de la botella se desactiva y no se obtiene experiencia.
    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent event){
        event.setShowEffect(false);
        event.setExperience(0);
        Block block = event.getEntity().getLocation().getBlock();
        block.getWorld().createExplosion(block.getLocation(), 5);
    }
}
