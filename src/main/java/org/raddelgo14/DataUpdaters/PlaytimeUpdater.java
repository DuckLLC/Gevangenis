package org.raddelgo14.DataUpdaters;

import org.bukkit.entity.Player;
import org.raddelgo14.Main;
import org.raddelgo14.Utils.Configs;
import org.raddelgo14.UserManagement.PlayerData;

public class PlaytimeUpdater {

    private final Configs playerData = new Configs("users.yaml");

    private static PlaytimeUpdater instance;

    public void updatePlaytime(int seconds, Player target){
        if (playerData.yamlConfig.getConfigurationSection(target.getUniqueId().toString()) == null){
            playerData.yamlConfig.createSection(target.getUniqueId().toString());
            playerData.yamlConfig.getConfigurationSection(target.getUniqueId().toString()).set("playtime", 0);
        }



        int currentPlaytime = playerData.yamlConfig.getConfigurationSection(target.getUniqueId().toString()).getInt("playtime");

        currentPlaytime+=seconds;
        playerData.yamlConfig.getConfigurationSection(target.getUniqueId().toString()).set("playtime", currentPlaytime);

        for (PlayerData pd : Main.getMain().playerData){
            if (pd.containsPlayer(target)){
                pd.playtime = currentPlaytime;
            }
        }
    }

    public int getPlaytime(Player target){
        if (playerData.yamlConfig.getConfigurationSection(target.getUniqueId().toString()) == null){
            playerData.yamlConfig.createSection(target.getUniqueId().toString());
            playerData.yamlConfig.getConfigurationSection(target.getUniqueId().toString()).set("playtime", 0);
            return 0;
        }
        return playerData.yamlConfig.getConfigurationSection(target.getUniqueId().toString()).getInt("playtime");
    }

    public static PlaytimeUpdater getInstance(){
        if (instance == null){
           instance = new PlaytimeUpdater();
        }
        return instance;
    }
}
