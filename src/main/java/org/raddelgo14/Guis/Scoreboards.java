package org.raddelgo14.Guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.raddelgo14.Main;

public class Scoreboards {

    public static void displayScoreboard(){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        assert manager != null;
        Scoreboard board = manager.getNewScoreboard();

        Objective objective = board.registerNewObjective("time", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("Gevangenis");

        Score score = objective.getScore(ChatColor.BLUE + "Time:" + Main.getMain().tt.getTimeH() + ":" + Main.getMain().tt.getTimeMinutes());
        score.setScore(2);

        for (Player p : Bukkit.getOnlinePlayers()){
            p.setScoreboard(board);
        }
    }
}
