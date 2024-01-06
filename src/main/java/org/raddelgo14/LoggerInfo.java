package org.raddelgo14;

import org.bukkit.Bukkit;

public class LoggerInfo {
    public static void onEnableLogger(){
        Bukkit.getLogger().info("Gevangenis: Plugin Enabled");
        Bukkit.getLogger().info("Running Version: " + Main.getMain().getDescription().getVersion());

        Bukkit.getLogger().info("All Files loaded. Registered Commands. Running API Version: " + Main.getMain().getDescription().getAPIVersion());
    }
}
