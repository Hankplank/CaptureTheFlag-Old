package com.delphinadrealms.Listeners;

import com.delphinadrealms.CTF;
import com.delphinadrealms.SQL.SQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by henry27 on 8/31/2017.
 */
public class PlayerJoinListener implements Listener {

    public PlayerJoinListener() {

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        System.out.println("CTF: PLAYER JOINED WITH NAME " + event.getPlayer().getDisplayName());
        Player player = event.getPlayer();
        player.sendMessage("Your UUID is: " + event.getPlayer().getUniqueId());
        SQLManager sql = new SQLManager();
        sql.addUser(event.getPlayer().getUniqueId(),event.getPlayer().getName(),true);
    }
}
