package org.raddelgo14.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.raddelgo14.MainGame.Contraban.WoodenClub;

public class GiveTestItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            WoodenClub wc = new WoodenClub();
            wc.giveItem((Player) sender);
        }
        return true;
    }
}
