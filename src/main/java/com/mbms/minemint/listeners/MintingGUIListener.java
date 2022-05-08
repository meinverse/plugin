package com.mbms.minemint.listeners;

import com.mbms.minemint.gui.MintingGUI;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class MintingGUIListener implements Listener {

    @EventHandler
    public void onMenuClick(@NotNull InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Component name = e.getView().title();
        ItemStack clickedItem = e.getCurrentItem();


        if (clickedItem == null) return;
        if (clickedItem.equals(MintingGUI.closeButton)) {
            e.getView().close();
            e.setCancelled(true);
            return;
        }

        if (clickedItem.equals(MintingGUI.mainButton))
            MintingGUI.openMainMenu(player);

        if (name.equals(MintingGUI.mainMenu)) onMainMenuClick(e, player, clickedItem);
        else if (name.equals(MintingGUI.mintingMenu)) onMintingMenuClick(e, player, clickedItem);
        else if (name.equals(MintingGUI.claimMenu)) onClaimMenuClick(e, player, clickedItem);
        else e.setCancelled(true);
    }

    private void onMainMenuClick(InventoryClickEvent e, Player player, ItemStack clickedItem) {
        if (clickedItem.equals(MintingGUI.mintButton))
            MintingGUI.openMintMenu(player);
        else if (clickedItem.equals(MintingGUI.claimButton))
            MintingGUI.openClaimMenu(player);

        // Makes items in the menu unmovable
        e.setCancelled(true);
    }

    private void onMintingMenuClick(InventoryClickEvent e, Player player, ItemStack clickedItem) {
        player.sendMessage("You clicked on the minting menu");

        // Makes items in the menu unmovable
        e.setCancelled(true);
    }

    private void onClaimMenuClick(InventoryClickEvent e, Player player, ItemStack clickedItem) {
        player.sendMessage("You clicked on the claim menu");

        // Makes items in the menu unmovable
        e.setCancelled(true);
    }
}
