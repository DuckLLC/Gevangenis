package org.raddelgo14.Guis;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.raddelgo14.Main;
import org.raddelgo14.UserManagement.PlayerData;

public class TeamGUI extends GUIs{
    public TeamGUI() {
        super(9, "Team Selection");

        setItem(3, new ItemStack(Material.ORANGE_CANDLE), player -> {
            for (PlayerData pd : Main.getMain().playerData){
                if (pd.containsPlayer(player)){
                    if (pd.getRole() == PlayerData.Roles.PRISONER){
                        player.sendMessage("You are already a Prisoner!");
                    }else{
                        player.sendMessage("Role set to Prisoner!");
                        pd.setRole(PlayerData.Roles.PRISONER);
                    }
                    break;
                }
            }
        });

        setItem(4, new ItemStack(Material.BLUE_CANDLE), player -> {
            for (PlayerData pd : Main.getMain().playerData){
                if (pd.containsPlayer(player)){
                    if (pd.getRole() == PlayerData.Roles.GUARD){
                        player.sendMessage("You are already a Guard!");
                    }else{
                        player.sendMessage("Role set to Guard!");
                        pd.setRole(PlayerData.Roles.GUARD);
                    }
                    break;
                }
            }
        });

        setItem(5, new ItemStack(Material.BLACK_CANDLE), player -> {
            for (PlayerData pd : Main.getMain().playerData){
                if (pd.containsPlayer(player)){
                    if (pd.getRole() == PlayerData.Roles.ARMY){
                        player.sendMessage("You are already a Army Official!");
                    }else{
                        player.sendMessage("Role set to Army Official!");
                        pd.setRole(PlayerData.Roles.ARMY);
                    }
                    break;
                }
            }
        });
    }

}
