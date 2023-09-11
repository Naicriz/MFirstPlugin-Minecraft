package me.naicriz.myfirstplugin;

import me.naicriz.myfirstplugin.listeners.ShearSheepListener;
import org.bukkit.plugin.java.JavaPlugin;
import me.naicriz.myfirstplugin.listeners.PlayerListeners;
import me.naicriz.myfirstplugin.listeners.XPBottleBreakListener;

public final class MyFirstPlugin_MC extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("My first plugin has been initiated!");
        // Registering the event listener class to the server plugin manager, so it can listen to events and execute the code.
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("My first plugin has been stopped! Goodbye ;)");
    }
}