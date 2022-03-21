package com.mbms.minemint.listeners;

import com.mbms.minemint.gui.MintingGUI;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public class MintingGUIListener implements Listener {

    @EventHandler
    public void onMenuClick(@NotNull InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Component name = e.getView().title();

        if (name.equals(MintingGUI.getMainMenu())) {
            player.sendMessage("You clicked on the main menu");
        } else if (name.equals(MintingGUI.getMintingMenu())) {
            player.sendMessage("You clicked on the minting menu");
        } else if (name.equals(MintingGUI.getClaimMenu())) {
            player.sendMessage("You clicked on the claim menu");
        }

        // Makes items in the menu unmovable
        e.setCancelled(true);
    }
}
