package com.delphinadrealms.Handlers;

import com.delphinadrealms.SQL.SQLManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by henry27 on 8/28/2017.
 */
public class CommandHandler implements CommandExecutor {

    public CommandHandler() {
    }



    private void changeClass(Player sender,String classToChangeTo) {
        SQLManager sql = new SQLManager();
        switch (classToChangeTo) {
            case "knight":
                sender.sendMessage("Changing class to: Knight");
                sql.changeClass(sender.getUniqueId(),"knight");
                break;
            case "mage":
                sender.sendMessage("Changing class to: Mage");
                sql.changeClass(sender.getUniqueId(),"mage");
                break;
            case "tank":
                sender.sendMessage("Changing class to: Tank");
                sql.changeClass(sender.getUniqueId(),"tank");
                break;
            default:
                sender.sendMessage("Please choose between from Knight, Mage and Tank. More classes will be added later.");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
        if (sender instanceof Player) {
            if (args.length > 0) {
                switch (args[0]) {
                    case "class":
                        changeClass(((Player) sender).getPlayer(),args[1]);
                        break;
                    default:
                        sender.sendMessage("Not a valid command!");
                        break;
                }
            } else {
                sender.sendMessage("CTF: Include some arguments!");
            }

            return true;
        } else {
            sender.sendMessage("You can't use this command from console!");
            return false;
        }
    }
}
