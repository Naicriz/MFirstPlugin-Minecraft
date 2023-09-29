package me.naicriz.myfirstplugin.commands;

import static me.naicriz.myfirstplugin.MyFirstPlugin_MC.getPlugin;

// import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            // Es un objeto especial que representa al jugador que ejecuta el comando.
            // Es uno de los pocos que puede hacerlo (Location).
            Location location = player.getLocation(); // Get the location of the player.

            String worldName = location.getWorld().getName(); // Get the name of the world where the player is.
            // World foundWorld = MyFirstPlugin_MC.getPlugin().getServer().getWorld(WorldName); // Get the world object from the server.

            // 1. Salvar cada valor de la localization x,y,z, world name, etc...
            // MyFirstPlugin_MC.getPlugin().getConfig().set("spawn.x", location.getX());
            // MyFirstPlugin_MC.getPlugin().getConfig().set("spawn.y", location.getY());
            // MyFirstPlugin_MC.getPlugin().getConfig().set("spawn.z", location.getZ());
            // MyFirstPlugin_MC.getPlugin().getConfig().set("spawn.world", WorldName);

            // 2. Salvar el objeto de localización directamente.
            getPlugin().getConfig().set("spawn", location);
            getPlugin().saveConfig();

            player.sendMessage("El Spawn ha sido asignado en: " + location.getX() + ", " + location.getY() + ", " + location.getZ() + " Mundo: " + worldName);

        } else {
            getPlugin().getLogger().info("Solo un jugador puede ejecutar este comando. Mueve la raja y entra al server.");
        }
        return true;
    }
}
