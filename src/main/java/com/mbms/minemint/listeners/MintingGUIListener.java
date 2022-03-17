package com.mbms.minemint.listeners;

import com.mbms.minemint.gui.MintingGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MintingGUIListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(MintingGUI.getMainMenu())) {
            player.sendMessage("You clicked on the main menu");
        } else if (e.getView().getTitle().equalsIgnoreCase(MintingGUI.getMintingMenu())) {
            player.sendMessage("You clicked on the minting menu");
        } else if (e.getView().getTitle().equalsIgnoreCase(MintingGUI.getClaimMenu())) {
            player.sendMessage("You clicked on the claim menu");
        }

        e.setCancelled(true);
    }
}
