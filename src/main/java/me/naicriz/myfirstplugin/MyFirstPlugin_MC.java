package me.naicriz.myfirstplugin;

import me.naicriz.myfirstplugin.commands.*;
import me.naicriz.myfirstplugin.listeners.*;

import org.bukkit.plugin.java.JavaPlugin;

/* Methods to register an event listener class to the server plugin manager */
// 1. static getter method to access plugin instance.
// 2. constructor injection(using a constructor to pass the plugin instance to the listener class).

public final class MyFirstPlugin_MC extends JavaPlugin {

    // Esta variable es para poder acceder a la instancia de la clase MyFirstPlugin_MC desde otras clases.
    private static MyFirstPlugin_MC plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        // System.out.println("My first plugin has been initiated!");
        getLogger().info("MyFirstPlugin ha sido inicializado correctamente!");

        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Registering the event listener class to the server plugin manager, so it can listen to events and execute the code.
        getServer().getPluginManager().registerEvents(new PlayerListeners(this), this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnListener(), this);
        // This is the second way to register an event listener class or any other class to the server plugin manager.
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityListener(), this);

        // Registering the command executor class to the server plugin manager, so it can listen to commands and execute the code.
        getCommand("die").setExecutor(new DieCommand_PartOne());
        getCommand("god").setExecutor(new GodCommand_PartTwo());
        getCommand("feed").setExecutor(new FeedCommand_PartTwo());
        getCommand("fairyfly").setExecutor(new FairyFlyCommand());
        getCommand("testperm").setExecutor(new TestPermCommand());
        getCommand("cmdargs").setExecutor(new CommandArguments());
        getCommand("fart").setExecutor(new FartCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("set").setExecutor(new SetMessageCommand());
        getCommand("setmessage").setExecutor(new SetJoinMessageCommand());
        // TabCompleter for the command /setmessage
        getCommand("setmessage").setTabCompleter(new SetJoinMessageCommand());
        //getCommand("cowsad").setExecutor(new CowSadCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MyFirstPlugin ha sido detenido! Goodbye ;)");
    }

    // This method is used to access the instance of the class MyFirstPlugin_MC from other classes.
    public static MyFirstPlugin_MC getPlugin() {
        return plugin;
    }
}