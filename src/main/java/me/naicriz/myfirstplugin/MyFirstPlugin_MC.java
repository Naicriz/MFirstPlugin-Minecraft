package me.naicriz.myfirstplugin;

import me.naicriz.myfirstplugin.commands.Commands_PartOne;
import me.naicriz.myfirstplugin.commands.FeedCommand_PartTwo;
import me.naicriz.myfirstplugin.commands.GodCommand_PartTwo;
import me.naicriz.myfirstplugin.listeners.ShearSheepListener;
import org.bukkit.plugin.java.JavaPlugin;
import me.naicriz.myfirstplugin.listeners.PlayerListeners;
import me.naicriz.myfirstplugin.listeners.XPBottleBreakListener;

public final class MyFirstPlugin_MC extends JavaPlugin {

    // Esta variable es para poder acceder a la instancia de la clase MyFirstPlugin_MC desde otras clases.
    private static MyFirstPlugin_MC plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        System.out.println("My first plugin has been initiated!");
        // Registering the event listener class to the server plugin manager, so it can listen to events and execute the code.
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);

        getCommand("die").setExecutor(new Commands_PartOne());
        getCommand("god").setExecutor((new GodCommand_PartTwo()));
        getCommand("feed").setExecutor((new FeedCommand_PartTwo()));
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("My first plugin has been stopped! Goodbye ;)");
    }


    // This method is used to access the instance of the class MyFirstPlugin_MC from other classes.
    public static MyFirstPlugin_MC getPlugin() {
        return plugin;
    }
}