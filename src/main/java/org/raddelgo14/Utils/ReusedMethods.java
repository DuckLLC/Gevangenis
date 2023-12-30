package org.raddelgo14.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.raddelgo14.Main;
import org.raddelgo14.UserManagement.PlayerData;

public class ReusedMethods {

    public static boolean hasContraband(Player p){
        String contrabandValue = NBTDataWriter.getNBTDataFromInventory(p.getInventory(), "Contraband");
        for (PlayerData pd : Main.getMain().playerData){
            if (pd.containsPlayer(p)){
                if (pd.getRole().equals(PlayerData.Roles.GUARD) || pd.getRole().equals(PlayerData.Roles.ARMY)){
                    return false;
                }
            }
        }
        return contrabandValue != null && contrabandValue.equals("true");
    }
}
