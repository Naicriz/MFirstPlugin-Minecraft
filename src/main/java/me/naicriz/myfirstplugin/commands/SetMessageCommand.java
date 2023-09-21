package me.naicriz.myfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

import static me.naicriz.myfirstplugin.MyFirstPlugin_MC.getPlugin;

public class SetMessageCommand implements CommandExecutor {
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
}
