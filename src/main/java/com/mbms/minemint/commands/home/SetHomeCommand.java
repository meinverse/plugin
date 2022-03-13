package com.mbms.minemint.commands.home;

import com.mbms.minemint.MineMint;
import com.mbms.minemint.utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SetHomeCommand extends SubCommand {
    @Override
    public String[] getNames() {
        return new String[]{"set", "create"};
    }

    @Override
    public String getDescription() {
        return "Set your home";
    }

    @Override
    public String getSyntax() {
        return "/home set <home name>(optional)";
    }

    @Override
    public void perform(@NotNull Player player, String @NotNull [] args) {
        Location location = player.getLocation();
        String world = Objects.requireNonNull(location.getWorld()).getName();
        String[] locationParts = {
                world,
                String.valueOf(location.getBlockX()),
                String.valueOf(location.getBlockY()),
                String.valueOf(location.getBlockZ()),
        };
        String locationString = String.join(",", locationParts);
        String name = "home-" + (args.length > 1 ? args[1] : "home");
        NamespacedKey namespaceKey = new NamespacedKey(MineMint.getPlugin(), name);

        player.getPersistentDataContainer().set(namespaceKey, PersistentDataType.STRING, locationString);
        player.sendMessage(ChatColor.GREEN + "Set your home" + (args.length > 1 ? " called " + args[1] : "") + " here!");
    }
}
