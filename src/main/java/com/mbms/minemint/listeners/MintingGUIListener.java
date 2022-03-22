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
        assert clickedItem != null;

        if (clickedItem.equals(MintingGUI.closeButton))
            e.getView().close();

        if (name.equals(MintingGUI.mainMenu)) {
            if (clickedItem.equals(MintingGUI.mintButton))
                MintingGUI.openMintMenu(player);
            else if (clickedItem.equals(MintingGUI.claimButton))
                MintingGUI.openClaimMenu(player);
        } else if (name.equals(MintingGUI.mintingMenu)) {
            player.sendMessage("You clicked on the minting menu");
        } else if (name.equals(MintingGUI.claimMenu)) {
            player.sendMessage("You clicked on the claim menu");
        }

        // Makes items in the menu unmovable
        e.setCancelled(true);
    }
}
