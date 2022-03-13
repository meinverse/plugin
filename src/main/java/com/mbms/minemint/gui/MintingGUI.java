package com.mbms.minemint.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MintingGUI {
    private static final String mainMenu = ChatColor.BLUE + "Main Menu";
    private static final String mintingMenu = "Minting";
    private static final String claimMenu = "Claiming";

    public static void openMainMenu(Player player) {
        Inventory menu = Bukkit.createInventory(player, 45, mainMenu);

        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta meta = playerHead.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Head");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "Explanation: " + ChatColor.RED + "...");
        lore.add(ChatColor.GOLD + "Date: " + ChatColor.AQUA + "...");
        meta.setLore(lore);
        playerHead.setItemMeta(meta);

        menu.addItem(playerHead);
        player.openInventory(menu);
    }

    public static void openMintMenu(Player player) {

    }

    public static void openClaimMenu(Player player) {

    }
}