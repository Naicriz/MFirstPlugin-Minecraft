package me.naicriz.myfirstplugin.listeners;

import me.naicriz.myfirstplugin.MyFirstPlugin_MC;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerListener implements Listener {

    private static MyFirstPlugin_MC pluginMFP;

    public PlayerListener(MyFirstPlugin_MC pluginMFP) {
        PlayerListener.pluginMFP = pluginMFP;
    }

    /**
     * <p>This method is used to send a message to a player that joins the server.</p>
     * @param event The event of a player joining the server.
     * @see PlayerJoinEvent
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        // Se obtiene el mensaje de bienvenida del archivo config.yml
        String joinMessagePlayer = pluginMFP.getConfig().getString("join-message-player");

        if (joinMessagePlayer != null) {
            joinMessagePlayer = joinMessagePlayer.replace("%player%", event.getPlayer().getDisplayName());
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', joinMessagePlayer));
        }

        // Se obtiene una lista de strings del archivo config.yml
        List<String> weapons = pluginMFP.getConfig().getStringList("weapons");
        for (String weapon : weapons) {
            // event.getPlayer().getInventory().addItem(getPlugin().getItem(weapon));
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "- &a" + weapon));
        }
    }

    @EventHandler
    public void onPlayerInteractRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block clickedBlock = event.getClickedBlock();
            try {
                // Se obtiene el nombre del bloque
                String blockName = clickedBlock.getType().toString();
                clickedBlock.setMetadata("clicked", new org.bukkit.metadata.FixedMetadataValue(pluginMFP, true));
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',"&fHas hecho clic en un bloque de " + blockName));
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',"&fEl bloque tiene la siguiente metadata: " + clickedBlock.getMetadata("clicked").get(0).asString()));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
