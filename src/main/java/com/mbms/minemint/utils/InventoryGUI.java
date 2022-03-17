package com.mbms.minemint.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;

public class InventoryGUI {
    protected ItemStack FILL_STACK;
    protected Inventory inventory;

    public InventoryGUI(Player player, int size, String name, Map<Integer, ItemStack> options) {
        FILL_STACK = createItem(Material.BLACK_STAINED_GLASS_PANE, " ");
        inventory = Bukkit.createInventory(player, size, name);

        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack item = options.get(i);
            if (item == null) inventory.setItem(i, FILL_STACK);
            else inventory.setItem(i, item);
        }
    }

    public ItemStack getFILL_STACK() {
        return FILL_STACK;
    }

    @NotNull
    public Inventory getInventory() {
        return inventory;
    }

    public void open(@NotNull Player player) {
        player.openInventory(inventory);
    }

    @NotNull
    public static ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
}
