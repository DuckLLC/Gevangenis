package org.raddelgo14.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.raddelgo14.Utils.NBTDataWriter;

public class GetContraband implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 0) {
            Player p = (Player) sender;

            String contrabandValue = NBTDataWriter.getNBTDataFromInventory(p.getInventory(), "Contraband");

            if (contrabandValue != null && contrabandValue.equals("true")) {
                p.sendMessage(ChatColor.GREEN + "Player " + p.getName() + " has contraband!");
            } else {
                p.sendMessage(ChatColor.RED + "Player " + p.getName() + " does not have contraband.");
                // Debug message
                System.out.println("Contraband value: " + contrabandValue);
            }
        }
        return true;
    }
}

