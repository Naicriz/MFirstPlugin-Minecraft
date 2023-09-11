package me.naicriz.myfirstplugin;

import org.bukkit.plugin.java.JavaPlugin;
import me.naicriz.myfirstplugin.listeners.PlayerListeners;

public final class MyFirstPlugin_MC extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("My first plugin has been initiated!");
        // Registering the event listener class to the server plugin manager so it can listen to events and execute the code.
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("My first plugin has been stopped! Goodbye ;)");
    }
}