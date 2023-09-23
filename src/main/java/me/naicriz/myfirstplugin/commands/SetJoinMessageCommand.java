package me.naicriz.myfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import static me.naicriz.myfirstplugin.MyFirstPlugin_MC.getPlugin;

public class SetJoinMessageCommand implements CommandExecutor, TabCompleter {

    private final List<String> validArguments = new ArrayList<>();

    public SetJoinMessageCommand() {
        validArguments.add("joinmessage");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0 || !args[0].equalsIgnoreCase("joinmessage")) {
            sender.sendMessage(ChatColor.RED + "Usage: /setmessage joinmessage <message>");
            return true;
        }

        if (args.length == 1) {
            sender.sendMessage(ChatColor.RED + "Please provide a join message in double quotes (e.g., \"/setmessage joinmessage \"Welcome back to the server!\"\"");
            return true;
        }

        // Reconstruct the message by joining all arguments after the first one
        String finalJoinMessage = String.join(" ", args).substring(12); // Remove "joinmessage "

        // Remove surrounding double quotes if present
        if (finalJoinMessage.startsWith("\"") && finalJoinMessage.endsWith("\"")) {
            finalJoinMessage = finalJoinMessage.substring(1, finalJoinMessage.length() - 1);
        }

        getPlugin().getConfig().set("join-message-player", finalJoinMessage);
        getPlugin().saveConfig();
        sender.sendMessage(ChatColor.GREEN + "Join message set to: " + finalJoinMessage);
        return true;
    }
    // This method is used to provide tab completion for the command.
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], validArguments, completions);
        }

        return completions;
    }
}
