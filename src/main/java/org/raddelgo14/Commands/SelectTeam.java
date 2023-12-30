package org.raddelgo14.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.raddelgo14.Guis.TeamGUI;

public class SelectTeam implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, String[] strings) {
        if (!(sender instanceof Player)){
            Bukkit.getLogger().info("You must be a player to run this command!");
            return true;
        }

        TeamGUI g = new TeamGUI();

        g.open((Player) sender);
        return true;
    }
}
