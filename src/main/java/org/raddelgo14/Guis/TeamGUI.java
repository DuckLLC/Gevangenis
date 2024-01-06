package org.raddelgo14.Guis;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.raddelgo14.Main;
import org.raddelgo14.UserManagement.PlayerData;
import org.raddelgo14.Utils.DateFormater;

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
                        if (pd.playtime >= (30 * 60)) {
                            player.sendMessage("Role set to Guard!");
                            pd.setRole(PlayerData.Roles.GUARD);
                        }else{
                            player.sendMessage("You don't have enough playtime! Required Playtime is 30 minutes. Current playtime: " + DateFormater.formatDate(pd.playtime));
                        }
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
                        if (pd.playtime >= (120 * 60)) {
                            player.sendMessage("Role set to an Army Official!");
                            pd.setRole(PlayerData.Roles.GUARD);
                        }else{
                            player.sendMessage("You don't have enough playtime! Required Playtime is 2 hours. Current playtime: " + DateFormater.formatDate(pd.playtime));
                        }
                    }
                    break;
                }
            }
        });
    }

}
