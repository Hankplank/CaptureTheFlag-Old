package com.delphinadrealms;

import com.delphinadrealms.Handlers.CommandHandler;
import com.delphinadrealms.Handlers.ConfigHandler;
import com.delphinadrealms.Listeners.PlayerJoinListener;
import com.delphinadrealms.SQL.SQLManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Created by henry27 on 8/28/2017.
 */
public class CTF extends JavaPlugin {

    SQLManager sql;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getCommand("ctf").setExecutor(new CommandHandler(this));
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(),this);
        sql = new SQLManager();
    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();
    }

}
