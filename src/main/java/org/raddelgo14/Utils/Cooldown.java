package org.raddelgo14.Utils;

import org.bukkit.entity.Player;
import org.raddelgo14.Main;

import java.util.Objects;

public class Cooldown {

    public Player pRef;
    public String contexs;
    int time;
    public Cooldown(String contex, int time, Player player){
        this.pRef = player;
        this.contexs = contex;
        this.time = time;
        Main.getMain().coolDowns.add(this);
    }

    public void deleteTempCooldown(){
        if (Objects.equals(contexs, "Temp")){Main.getMain().coolDowns.remove(this);}
    }

    public void countDown(){
        this.time--;
        if (isTimerUp(false)){
            Main.getMain().coolDowns.remove(this);
        }
    }

    public boolean isTimerUp(boolean isTemp){
        if (isTemp) return true;
        return time <= 0;
    }

    public String getContext(){
        return contexs;
    }

    public Player getPlayer(){
        return pRef;
    }
}
