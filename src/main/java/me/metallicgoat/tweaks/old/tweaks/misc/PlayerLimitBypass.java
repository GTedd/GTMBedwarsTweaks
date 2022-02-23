package me.metallicgoat.tweaks.old.tweaks.misc;

import me.metallicgoat.tweaks.utils.ServerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLimitBypass implements Listener {
    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent event){
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL && ServerManager.getConfig().getBoolean("Bypass-PlayerLimit")) {
            event.allow();
        }
    }
}
