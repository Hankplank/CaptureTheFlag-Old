package com.delphinadrealms.Handlers;

import com.delphinadrealms.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by henry27 on 8/28/2017.
 */
public class CommandHandler extends JavaPlugin implements CommandExecutor {


    public CommandHandler(Main main) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
        if (sender instanceof Player && args.length > 2) {
            Player player = (Player) sender;
            player.sendMessage("Hello!");
            player.sendMessage(args[0] + args[1] + args[2]);
            return true;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                Player player = (Player) sender;
                player.sendMessage("Reloaded config.");

                return true;
            } else {
                return false;
            }
        } else {
            sender.sendMessage("You must use this command from in-game, sorry.");
            return false;
        }
    }
}
