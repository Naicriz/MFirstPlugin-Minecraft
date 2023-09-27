package me.naicriz.myfirstplugin.listeners;

import me.naicriz.myfirstplugin.MyFirstPlugin_MC;

import org.bukkit.ChatColor;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class EntityListener implements Listener {
    private final MyFirstPlugin_MC pluginMFP;
    public EntityListener(MyFirstPlugin_MC pluginMFP) {
        this.pluginMFP = pluginMFP;
    }

    @EventHandler
    public void onEntityRightClick(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();

        if (event.getRightClicked() instanceof Cow cow) {

            cow.setCustomName(ChatColor.RED + "VACA ESTRESADA");
            cow.setCustomNameVisible(true);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aVaca: &eEstoy cansada jefe, cansada de tanto luchar..."));
            BukkitTask task = new BukkitRunnable() {
                @Override
                public void run() {
                    cow.getWorld().createExplosion(cow.getLocation(), 2.0F);
                    cow.getHurtSound();
                }
            }.runTaskLater(pluginMFP, 20 * 3); // 20 ticks * 3 seconds
        }
    }
}
