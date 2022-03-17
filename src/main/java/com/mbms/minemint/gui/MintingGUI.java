package com.mbms.minemint.gui;

import com.mbms.minemint.utils.InventoryGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class MintingGUI {
    private static final String mainMenu = ChatColor.BLUE + "Main Menu";
    private static final String mintingMenu = "Minting";
    private static final String claimMenu = "Claiming";

    public static String getMainMenu() {
        return mainMenu;
    }

    public static String getMintingMenu() {
        return mintingMenu;
    }

    public static String getClaimMenu() {
        return claimMenu;
    }

    public static void openMainMenu(Player player) {
        Map<Integer, ItemStack> options = new HashMap<>();
        options.put(0, new ItemStack(Material.PLAYER_HEAD, 1));

        InventoryGUI gui = new InventoryGUI(player, 9, mainMenu, options);
        gui.open(player);
    }

    public static void openMintMenu(Player player) {

    }

    public static void openClaimMenu(Player player) {

    }
}