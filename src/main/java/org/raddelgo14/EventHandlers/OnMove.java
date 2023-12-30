package org.raddelgo14.EventHandlers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.raddelgo14.Main;
import org.raddelgo14.Utils.Cooldown;
import org.raddelgo14.Utils.NBTDataWriter;

import java.util.Objects;

public class OnMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent mv){
       Location playerLocation = mv.getPlayer().getLocation();
       Location playerLocationUnderGround = playerLocation.subtract(0, 2, 0);
       Cooldown cd = null;

       for (Cooldown c : Main.getMain().coolDowns){
           if (Objects.equals(c.getContext(), "Scanner") && c.getPlayer() == mv.getPlayer()){
               cd = c;
               break;
           }
       }
       Boolean isTemp = false;

       if (cd == null){
           cd = new Cooldown("Temp", 1000, mv.getPlayer());

           isTemp = true;
       }

       if ((playerLocationUnderGround.getBlock().getType() == Material.RED_WOOL) && cd.isTimerUp(isTemp)){
           Player p = mv.getPlayer();

           String contrabandValue = NBTDataWriter.getNBTDataFromInventory(p.getInventory(), "Contraband");

           if (contrabandValue != null && contrabandValue.equals("true")) {
               p.sendMessage(ChatColor.GREEN + "Player " + p.getName() + " has contraband!");
           } else {
               p.sendMessage(ChatColor.RED + "Player " + p.getName() + " does not have contraband.");
               // Debug message
               System.out.println("Contraband value: " + contrabandValue);
           }
           cd.deleteTempCooldown();
           new Cooldown("Scanner", 2, mv.getPlayer());
       }
    }
}
