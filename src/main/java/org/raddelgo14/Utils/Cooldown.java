package org.raddelgo14.Utils;

import org.bukkit.entity.Player;
import org.raddelgo14.Main;

import java.util.Objects;

public class Cooldown {

    static long cooldownTimeInSeconds = 2;

    public static boolean isOnCooldown(Player player) {
        String playerName = player.getName();

        if (Main.getMain().cooldowns.containsKey(playerName)) {
            long lastTimeUsed = Main.getMain().cooldowns.get(playerName);
            long currentTime = System.currentTimeMillis() / 1000; // Convert to seconds


            if (currentTime - lastTimeUsed < cooldownTimeInSeconds) {
                // Player is still on cooldown
                return true;
            }
        }

        // Player is not on cooldown or cooldown has expired
        return false;
    }

    // Example method to set a cooldown for a player
    public static void setCooldown(Player player) {
        String playerName = player.getName();
        long currentTime = System.currentTimeMillis() / 1000; // Convert to seconds

        Main.getMain().cooldowns.put(playerName, currentTime);
    }
}
