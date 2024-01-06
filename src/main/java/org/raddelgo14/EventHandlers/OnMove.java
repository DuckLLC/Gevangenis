package org.raddelgo14.EventHandlers;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.raddelgo14.Main;
import org.raddelgo14.UserManagement.PlayerData;
import org.raddelgo14.Utils.Cooldown;
import org.raddelgo14.Utils.NBTDataWriter;
import org.raddelgo14.Utils.ReusedMethods;

import java.util.Objects;

public class OnMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent mv){
       Location playerLocation = mv.getPlayer().getLocation();
       Location playerLocationUnderGround = playerLocation.subtract(0, 2, 0);

       if ((playerLocationUnderGround.getBlock().getType() == Material.RED_WOOL) && !(Cooldown.isOnCooldown(mv.getPlayer()))){
           if (ReusedMethods.hasContraband(mv.getPlayer())){
               mv.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 900, 1));
               for (Player p : Bukkit.getOnlinePlayers()){
                   for (PlayerData pd : Main.getMain().playerData){
                       if (pd.containsPlayer(p)){
                           if (pd.getPlayer().hasPermission("op")){pd.getPlayer().sendMessage(ChatColor.RED + mv.getPlayer().getName() + " HAS CONTRABAND");}
                           if (pd.getRole().equals(PlayerData.Roles.GUARD)){
                               pd.getPlayer().sendMessage(ChatColor.RED + mv.getPlayer().getName() + " HAS CONTRABAND");
                               pd.getPlayer().playSound(pd.getPlayer().getLocation(), Sound.ENTITY_HORSE_DEATH, 20, 1);
                               break;
                           }
                       }
                   }
               }
           }
           Cooldown.setCooldown(mv.getPlayer());
       }
    }
}
