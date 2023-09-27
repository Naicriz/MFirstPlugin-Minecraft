package me.naicriz.myfirstplugin.listeners;

import me.naicriz.myfirstplugin.MyFirstPlugin_MC;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

import static me.naicriz.myfirstplugin.MyFirstPlugin_MC.getPlugin;

public class PlayerListeners implements Listener {

    private static MyFirstPlugin_MC pluginMFP;

    public PlayerListeners(MyFirstPlugin_MC pluginMFP) {
        this.pluginMFP = pluginMFP;
    }

    /**
     * Este método está obsoleto y no debe utilizarse directamente.
     * Deberías usar el método {@link #onPlayerJoinSteroids(PlayerJoinEvent)} en su lugar.
     * @param event El evento de un jugador que se unió.
     * @deprecated Este método está obsoleto. Deberías usar el método {@link #onPlayerJoinSteroids(PlayerJoinEvent)} en su lugar.
     */
    /* @Deprecated
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage("Bienvenido al servidor, " + event.getPlayer().getName() + "!");
        onPlayerJoinSteroids(event);
    }*/
    @EventHandler
    public void onPlayerJoinSteroids(PlayerJoinEvent event) {

        // Se obtiene el mensaje de bienvenida del archivo config.yml
        String joinMessagePlayer = pluginMFP.getConfig().getString("join-message-player");

        if (joinMessagePlayer != null) {
            joinMessagePlayer = joinMessagePlayer.replace("%player%", event.getPlayer().getDisplayName());
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', joinMessagePlayer));
        }

        List<String> weapons = getPlugin().getConfig().getStringList("weapons");
        for (String weapon : weapons) {
            // event.getPlayer().getInventory().addItem(getPlugin().getItem(weapon));
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "- " + "&a" + weapon));
        }
    }
}
