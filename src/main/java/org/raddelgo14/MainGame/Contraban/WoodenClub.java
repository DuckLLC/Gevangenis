package org.raddelgo14.MainGame.Contraban;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.raddelgo14.MainGame.AbstractItem;
import org.raddelgo14.Utils.NBTDataWriter;

public class WoodenClub extends AbstractItem {

    @Override
    public void giveItem(Player p){
        ItemStack item = new ItemStack(Material.WOODEN_SWORD);

        NBTDataWriter.setNBTData(item, "Contraband", "true");

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("Wooden Club");

        item.setItemMeta(meta);

        p.getInventory().addItem(item);
    }
}
