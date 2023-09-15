package me.naicriz.myfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static me.naicriz.myfirstplugin.MyFirstPlugin_MC.getPlugin;

public class FairyFlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        // FairyFly - Concede el permiso de volar al jugador que ejecuta el comando.
        if (!player.isFlying() && player.hasPermission("myfirstplugin.fairyfly") && command.getName().equalsIgnoreCase("fairyfly")) {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage("Ahora eres un hada, vuela pequña, vuela y se libre. (aún que solo por diez segundos...)");
            // Schedule a task to disable flight after 10 seconds
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage("Has perdido tus alas, ahora eres un ser mundano, cuanto lo siento.");
                }
            }.runTaskLater(getPlugin(), 20 * 10); // 20 ticks * 10 seconds
        } else {
            player.sendMessage("No tienes permisos para ejecutar este comando.");
            getPlugin().getServer().getConsoleSender().sendMessage("El jugador " + player.getName() + " ha intentado ejecutar el comando /fairyfly sin permisos.");

        }
        return true;
    }
}
