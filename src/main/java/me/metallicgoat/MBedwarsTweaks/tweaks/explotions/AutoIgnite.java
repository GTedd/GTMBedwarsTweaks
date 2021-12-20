package me.metallicgoat.MBedwarsTweaks.tweaks.explotions;

import me.metallicgoat.MBedwarsTweaks.MBedwarsTweaks;
import me.metallicgoat.MBedwarsTweaks.utils.ServerManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AutoIgnite implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        //One tick later
        Bukkit.getServer().getScheduler().runTaskLater(plugin(), () -> {
            //Check if its tnt
            if (e.getBlock().getType() == Material.TNT) {
                //Check if auto ignite is enabled
                if (ServerManager.getConfig().getBoolean("TNT.Auto-Ignite")) {
                    //add new tnt with custom fuse time
                    e.getBlockPlaced().setType(Material.AIR);
                    TNTPrimed tnt = e.getPlayer().getWorld().spawn(e.getBlockPlaced().getLocation().add(.5, 0, .5), TNTPrimed.class);
                    tnt.setFuseTicks(ServerManager.getConfig().getInt("TNT.Delay") * 20);
                }
            }
        }, 1L);
    }

    private static MBedwarsTweaks plugin() {
        return MBedwarsTweaks.getInstance();
    }
}
