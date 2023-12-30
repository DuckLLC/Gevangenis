package org.raddelgo14.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.raddelgo14.DataUpdaters.PlaytimeUpdater;
import org.raddelgo14.Main;
import org.raddelgo14.UserManagement.PlayerData;
import org.raddelgo14.Utils.DateFormater;

public class GetStatistics implements CommandExecutor {
    @EventHandler
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if (!(sender instanceof Player)){
            Bukkit.getLogger().info("You must be a Player to use /GetStatistics");
            return true;
        }

        if (args.length == 1){
            Player p = Bukkit.getPlayer(args[0]);
            if (p == null){sender.sendMessage(ChatColor.RED + "Player cannot be found or is offline"); return true;}

            Main m = Main.getMain();
            for (PlayerData pd : m.playerData){
                if (pd.containsPlayer(p)){
                    sender.sendMessage("Info on player: " + p.getName());
                    sender.sendMessage("Role: " + pd.getRole().toString());
                    sender.sendMessage("Playtime: " + DateFormater.formatDate(pd.playtime));
                    break;
                }
            }
            return true;
        }

        if (args.length == 0){
            Player p = (Player) sender;

            Main m = Main.getMain();
            for (PlayerData pd : m.playerData){
                if (pd.containsPlayer(p)){
                    sender.sendMessage("Info on player: " + p.getName());
                    sender.sendMessage("Role: " + pd.getRole().toString());
                    sender.sendMessage("Playtime: " + DateFormater.formatDate(pd.playtime));
                    break;
                }
            }
            return true;
        }

        sender.sendMessage("Too many Arguments");
        return true;

    }
}
