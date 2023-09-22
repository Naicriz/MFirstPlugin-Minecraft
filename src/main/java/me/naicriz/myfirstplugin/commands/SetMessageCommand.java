package me.naicriz.myfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

import static me.naicriz.myfirstplugin.MyFirstPlugin_MC.getPlugin;

public class SetMessageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Metodo v2 Async
        // Este método NO debe ser usado en COMDANDOS de este tipo, solo en tareas pesadas u operaciones que puedan tardar.
        //
        if (args[0].equalsIgnoreCase("joinmsg")) {
            if (args.length >= 2) {
                // Combina los argumentos restantes en un mensaje
                String finalMessageString = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

                // Programa una tarea asíncrona para guardar la configuración
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        getPlugin().getConfig().set("join-message-player", finalMessageString);
                        getPlugin().saveConfig();
                    }
                }.runTaskAsynchronously(getPlugin());

                sender.sendMessage("Mensaje de bienvenida configurado de forma asíncrona.");
            } else {
                sender.sendMessage("Uso incorrecto. Debes proporcionar un mensaje de bienvenida.");
            }
        }
        return true;
    }
}

// Metodo v1
/*public class SetMessageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args[0].equalsIgnoreCase("joinmsg")) {
            // String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
            // StringBuilder message = new StringBuilder();
            String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
            StringBuilder strbuilder = new StringBuilder(message);
            String finalMessageString = strbuilder.toString();
            getPlugin().getConfig().set("join-message-player", finalMessageString);
            getPlugin().saveConfig();
        }
    return true;
    }
}*/
