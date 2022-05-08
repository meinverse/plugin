package com.mbms.minemint.gui;

import com.mbms.minemint.utils.InventoryGUI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class MintingGUI {
    public static final Component mainMenu = Component.text("Main Menu").color(NamedTextColor.AQUA);
    public static final Component mintingMenu = Component.text("Minting").color(NamedTextColor.AQUA);
    public static final Component claimMenu = Component.text("Claiming").color(NamedTextColor.AQUA);
    public static final ItemStack mintButton = InventoryGUI.createItem(Material.EMERALD, Component.text("Mint").color(NamedTextColor.GREEN));
    public static final ItemStack claimButton = InventoryGUI.createItem(Material.DIAMOND, Component.text("Claim").color(NamedTextColor.AQUA));
    public static final ItemStack closeButton = InventoryGUI.createItem(Material.SKELETON_SKULL, Component.text("Close"));
    public static final ItemStack mainButton = InventoryGUI.createItem(Material.ARROW, Component.text("Main Menu"));


    public static void openMainMenu(Player player) {
        Map<Integer, ItemStack> options = new HashMap<>();

        options.put(3, mintButton);
        options.put(5, claimButton);

        options.put(8, closeButton);
        InventoryGUI gui = new InventoryGUI(player, 9, mainMenu, options);
        gui.open(player);
    }

    public static void openMintMenu(Player player) {
        Map<Integer, ItemStack> options = new HashMap<>();

        options.put(0, mainButton);
        options.put(8, closeButton);
        InventoryGUI gui = new InventoryGUI(player, 9, mintingMenu, options);
        gui.open(player);
    }

    public static void openClaimMenu(Player player) {
        Map<Integer, ItemStack> options = new HashMap<>();

        options.put(0, mainButton);
        options.put(8, closeButton);
        InventoryGUI gui = new InventoryGUI(player, 9, claimMenu, options);
        gui.open(player);
    }
}