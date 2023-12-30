package org.raddelgo14;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.raddelgo14.Commands.GetContraband;
import org.raddelgo14.Commands.GetStatistics;
import org.raddelgo14.Commands.GiveTestItem;
import org.raddelgo14.Commands.SelectTeam;
import org.raddelgo14.DataUpdaters.PlaytimeUpdater;
import org.raddelgo14.Guis.GuiListener;
import org.raddelgo14.UserManagement.PlayerData;
import org.raddelgo14.Utils.Configs;

import java.util.ArrayList;
import java.util.Objects;

public class Main extends JavaPlugin implements Listener {
    public ArrayList<PlayerData> playerData = new ArrayList<PlayerData>();

    private PlaytimeUpdater ptime;
    public static Main m;
    public static Main getMain(){
        return m;
    }
    @Override
    public void onEnable(){
        m = this;

        Objects.requireNonNull(getCommand("GetStatistics")).setExecutor(new GetStatistics());
        Objects.requireNonNull(getCommand("SelectTeam")).setExecutor(new SelectTeam());
        Objects.requireNonNull(getCommand("GiveTestItem")).setExecutor(new GiveTestItem());
        Objects.requireNonNull(getCommand("GetContraband")).setExecutor(new GetContraband());

        if (!this.getDataFolder().exists()) this.getDataFolder().mkdir();

        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new GuiListener(), this);

        Bukkit.getLogger().info("Gevangenis: Plugin Enabled");
        Bukkit.getLogger().info("Running Version: " + this.getDescription().getVersion());

        ptime = PlaytimeUpdater.getInstance();


        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()){
                    ptime.updatePlaytime(1, p);
                }
            }
        }, 0L, 20L);
    }

    @Override
    public void onDisable(){
        Configs.saveAll();
    }

    @EventHandler
    public void onConnection(PlayerJoinEvent pEvent){
        PlayerData p = new PlayerData(pEvent.getPlayer().getUniqueId());

        if (p.isNull()){return;}

        playerData.add(p);
    }
}