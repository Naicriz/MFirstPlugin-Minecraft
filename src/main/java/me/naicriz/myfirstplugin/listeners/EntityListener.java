package me.naicriz.myfirstplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import static me.naicriz.myfirstplugin.MyFirstPlugin_MC.getPlugin;

public class EntityListener implements Listener {

    @EventHandler
    public void onEntityRightClick(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();

        if (event.getRightClicked().getType() == EntityType.COW) {
            Cow cow = (Cow) event.getRightClicked();

            // Verificar si la vaca ya tiene un nombre personalizado antes de hacer cambios
            if (cow.getCustomName() == null || !cow.getCustomName().equals(ChatColor.RED + "VACA ESTRESADA")) {
                cow.setCustomName(ChatColor.RED + "VACA ESTRESADA");
                cow.setCustomNameVisible(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aVaca: &eEstoy cansada jefe, cansada de tanto luchar..."));

                BukkitTask task = new BukkitRunnable() {
                    @Override
                    public void run() {
                        cow.getWorld().createExplosion(cow.getLocation(), 2.0F);
                        cow.getHurtSound();
                    }
                }.runTaskLater(getPlugin(), 20 * 3); // 20 ticks * 3 seconds
            }
        }
    }
}
