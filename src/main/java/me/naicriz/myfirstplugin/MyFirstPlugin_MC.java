package me.naicriz.myfirstplugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.naicriz.myfirstplugin.commands.TestPermCommand;
import me.naicriz.myfirstplugin.commands.DieCommand_PartOne;
import me.naicriz.myfirstplugin.commands.FeedCommand_PartTwo;
import me.naicriz.myfirstplugin.commands.GodCommand_PartTwo;
import me.naicriz.myfirstplugin.commands.FairyFlyCommand;

import me.naicriz.myfirstplugin.listeners.DeathListener;
import me.naicriz.myfirstplugin.listeners.ShearSheepListener;
import me.naicriz.myfirstplugin.listeners.PlayerListeners;
import me.naicriz.myfirstplugin.listeners.XPBottleBreakListener;

/* Methods to register an event listener class to the server plugin manager */
// 1. static getter method to acces plugin instance.
// 2. constructor injection(using a constructor to pass the plugin instance to the listener class).

public final class MyFirstPlugin_MC extends JavaPlugin {

    // Esta variable es para poder acceder a la instancia de la clase MyFirstPlugin_MC desde otras clases.
    private static MyFirstPlugin_MC plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        // System.out.println("My first plugin has been initiated!");
        getLogger().info("MyFirstPlugin has been initiated!");

        // Registering the event listener class to the server plugin manager, so it can listen to events and execute the code.
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        // This is the second way to register an event listener class to the server plugin manager.
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);

        // Registering the command executor class to the server plugin manager, so it can listen to commands and execute the code.
        getCommand("die").setExecutor(new DieCommand_PartOne());
        getCommand("god").setExecutor(new GodCommand_PartTwo());
        getCommand("feed").setExecutor(new FeedCommand_PartTwo());
        getCommand("fairyfly").setExecutor(new FairyFlyCommand());
        getCommand("testperm").setExecutor(new TestPermCommand());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("My first plugin has been stopped! Goodbye ;)");
    }


    // This method is used to access the instance of the class MyFirstPlugin_MC from other classes.
    public static MyFirstPlugin_MC getPlugin() {
        return plugin;
    }
}