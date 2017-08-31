package com.delphinadrealms.Handlers;

import com.delphinadrealms.CTF;
import com.delphinadrealms.SQL.SQLManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by henry27 on 8/28/2017.
 */
public class CommandHandler implements CommandExecutor {

    public CommandHandler() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
        //if (sender instanceof Player) {
            Player player = ((Player) sender);
            player.sendMessage("Your UUID is: " + player.getUniqueId());
            SQLManager sql = new SQLManager();
            sql.addUser(player.getUniqueId(),player.getName(),true);
            return true;
        //} else {
        //}
    }
}
