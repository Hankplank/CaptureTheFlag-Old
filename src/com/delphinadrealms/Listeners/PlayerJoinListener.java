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
        SQLManager sql = new SQLManager();
        sql.addUser(event.getPlayer().getUniqueId(),event.getPlayer().getName());
    }
}
