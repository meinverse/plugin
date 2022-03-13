package com.mbms.minemint.commands.home;

import com.mbms.minemint.MineMint;
import com.mbms.minemint.utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
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
        int homeCount = getHomeCount(player);
        if (homeCount >= MineMint.getPlugin().getConfig().getInt("max-homes")) {
            player.sendMessage(ChatColor.RED + "You have reached the maximum amount of homes!");
            return;
        }
        if (args.length > 1 && args[1].length() > 16) {
            player.sendMessage(ChatColor.RED + "The home name must be 16 characters or less!");
            return;
        }

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

    private int getHomeCount(@NotNull Player player) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        int homeCount = 0;
        for (NamespacedKey key : data.getKeys())
            if (key.getKey().startsWith("home-")) homeCount++;
        return homeCount;
    }
}
