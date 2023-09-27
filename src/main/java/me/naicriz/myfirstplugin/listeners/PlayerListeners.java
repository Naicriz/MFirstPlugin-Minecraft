package me.naicriz.myfirstplugin.listeners;

import me.naicriz.myfirstplugin.MyFirstPlugin_MC;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerListeners implements Listener {

    private final MyFirstPlugin_MC pluginMFP;

    public PlayerListeners(MyFirstPlugin_MC pluginMFP) {
        this.pluginMFP = pluginMFP;
    }

    /**
     * <p>This method is used to send a message to a player that joins the server.</p>
     * @param event The event of a player joining the server.
     * @return A message to the player that joined the server.
     */
    @EventHandler
    public void onPlayerJoinSteroids(PlayerJoinEvent event) {

        // Se obtiene el mensaje de bienvenida del archivo config.yml
        String joinMessagePlayer = pluginMFP.getConfig().getString("join-message-player");

        if (joinMessagePlayer != null) {
            joinMessagePlayer = joinMessagePlayer.replace("%player%", event.getPlayer().getDisplayName());
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', joinMessagePlayer));
        }

        List<String> weapons = pluginMFP.getConfig().getStringList("weapons");
        for (String weapon : weapons) {
            // event.getPlayer().getInventory().addItem(getPlugin().getItem(weapon));
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "- " + "&a" + weapon));
        }
    }
}
