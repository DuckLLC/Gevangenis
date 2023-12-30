package org.raddelgo14.Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.configuration.file.YamlConfiguration;

public class Configs {
    private static org.raddelgo14.Main Main;
    private static final File dataFolder = org.raddelgo14.Main.getMain().getDataFolder();
    private static final Set<Configs> allManagers = new HashSet<Configs>();

    private final File file;
    public YamlConfiguration yamlConfig;

    public Configs(String path) {
        file = new File(dataFolder, path);

        allManagers.add(this);

        reload();
    }

    public void save() {
        try {
            this.yamlConfig.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.yamlConfig = YamlConfiguration.loadConfiguration(file);
    }

    public static void saveAll() {
        for (Configs ym : allManagers) {
            ym.save();
        }
    }
}