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
    private static final Component mainMenu = Component.text("Main Menu").color(NamedTextColor.AQUA);
    private static final Component mintingMenu = Component.text("Minting").color(NamedTextColor.AQUA);
    private static final Component claimMenu = Component.text("Claiming").color(NamedTextColor.AQUA);

    public static Component getMainMenu() {
        return mainMenu;
    }

    public static Component getMintingMenu() {
        return mintingMenu;
    }

    public static Component getClaimMenu() {
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