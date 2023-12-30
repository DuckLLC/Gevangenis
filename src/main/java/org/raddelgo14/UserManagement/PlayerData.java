package org.raddelgo14.UserManagement;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.raddelgo14.DataUpdaters.PlaytimeUpdater;

import java.util.UUID;

public class PlayerData {

    private UUID isPointingTo;

    private Roles currentRole;

    public int playtime;

    public PlayerData(UUID pointsTo){
        if(Bukkit.getPlayer(pointsTo) == null){Bukkit.getLogger().warning("Error in Player.java: Cannot set isPointingTo: Player is Null"); return;}

        this.isPointingTo = pointsTo;
        this.currentRole = Roles.PRISONER;

        this.playtime = PlaytimeUpdater.getInstance().getPlaytime(Bukkit.getPlayer(pointsTo));
    }

    public Roles getRole(){
        return currentRole;
    }

    static public enum Roles{
        PRISONER,
        GUARD,
        FUGITIVE,
        ARMY
    }

    public boolean isNull(){
        return isPointingTo == null;
    }

    public boolean containsPlayer(Player p){
        return p.equals(Bukkit.getPlayer(isPointingTo));
    }

    public void setRole(Roles r){
        currentRole = r;
    }
}
