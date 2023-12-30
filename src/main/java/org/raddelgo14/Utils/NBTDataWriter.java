package org.raddelgo14.Utils;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import org.raddelgo14.Main;

import java.util.Objects;

public class NBTDataWriter {

    public static void setNBTData(ItemStack itemStack, String key, String value) {
        ItemMeta meta = itemStack.getItemMeta();

        // Set the NBT data on the item
        assert meta != null;
        meta.getPersistentDataContainer().set(
                new NamespacedKey(Main.getMain(), key),
                PersistentDataType.STRING,
                value
        );

        itemStack.setItemMeta(meta);
    }

    public static String getNBTDataFromInventory(PlayerInventory inventory, String key) {
        for (ItemStack item : inventory.getContents()) {
            // Check if the item is not null and has the specified NBT key
            if (item != null && hasNBTData(item, key)) {
                // Retrieve and return the NBT data
                return getNBTData(item, key);
            }
        }
        return null; // NBT data not found in the inventory
    }

    // Helper method to check if an item has NBT data with a specific key
    private static boolean hasNBTData(ItemStack itemStack, String key) {
        return Objects.requireNonNull(itemStack.getItemMeta()).getPersistentDataContainer().has(
                new NamespacedKey(Main.getMain(), key),
                PersistentDataType.STRING
        );
    }
    // Example of getting NBT data
    public static String getNBTData(ItemStack itemStack, String key) {
        ItemMeta meta = itemStack.getItemMeta();

        // Retrieve the NBT data from the item
        assert meta != null;

        return meta.getPersistentDataContainer().get(
                new NamespacedKey(Main.getMain(), key),
                PersistentDataType.STRING
        );
    }
}
