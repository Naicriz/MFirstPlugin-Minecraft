package me.naicriz.myfirstplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin_MC extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("My first plugin has been initiated!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("My first plugin has been stopped! Goodbye ;)");
    }
}