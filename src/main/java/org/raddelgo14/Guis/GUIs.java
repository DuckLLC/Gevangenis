package org.raddelgo14.Guis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class GUIs {
    public static Map<UUID, GUIs> inventoriesByUUID = new HashMap<>();
    public static Map<UUID, UUID> openInventories = new HashMap<>();
    private final Inventory yourInventory;
    private final UUID uuid;
    private final Map<Integer, YourGUIAction> actions;

    public GUIs(int invSize, String invName) {
        uuid = UUID.randomUUID();
        yourInventory = Bukkit.createInventory(null, invSize, invName);
        actions = new HashMap<>();
        inventoriesByUUID.put(getUuid(), this);
    }

    public interface YourGUIAction {
        void click(Player player);
    }

    public void setItem(int slot, ItemStack stack, YourGUIAction action){
        yourInventory.setItem(slot, stack);
        if (action != null){
            actions.put(slot, action);
        }
    }

    public void setItem(int slot, ItemStack stack){
        setItem(slot, stack, null);
    }

    public void open(Player p){
        p.openInventory(yourInventory);
        openInventories.put(p.getUniqueId(), getUuid());
    }

    public UUID getUuid() {
        return uuid;
    }

    public static Map<UUID, GUIs> getInventoriesByUUID() {
        return inventoriesByUUID;
    }

    public static Map<UUID, UUID> getOpenInventories() {
        return openInventories;
    }

    public Map<Integer, YourGUIAction> getActions() {
        return actions;
    }
}

