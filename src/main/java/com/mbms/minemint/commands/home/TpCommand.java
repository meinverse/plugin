package com.mbms.minemint.commands.home;

import com.mbms.minemint.MineMint;
import com.mbms.minemint.utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class TpCommand extends SubCommand {
    @Override
    public String[] getNames() {
        return new String[]{"tp", "teleport"};
    }

    @Override
    public String getDescription() {
        return "Tp to your home";
    }

    @Override
    public String getSyntax() {
        return "/home tp <home name>(optional)";
    }

    @Override
    public void perform(@NotNull Player player, String @NotNull [] args) {
        String name = "home-" + (args.length > 1 ? args[1] : "home");
        NamespacedKey namespaceKey = new NamespacedKey(MineMint.getPlugin(), name);
        PersistentDataContainer data = player.getPersistentDataContainer();

        if (data.has(namespaceKey, PersistentDataType.STRING)) {
            String locationString = data.get(namespaceKey, PersistentDataType.STRING);
            assert locationString != null;
            String[] locationParts = locationString.split(",");
            World world = MineMint.getPlugin().getServer().getWorld(locationParts[0]);
            assert world != null;
            int x = Integer.parseInt(locationParts[1]);
            int y = Integer.parseInt(locationParts[2]);
            int z = Integer.parseInt(locationParts[3]);
            Location location = world.getBlockAt(x, y, z).getLocation();
            player.teleport(location);
            player.sendMessage(ChatColor.GREEN + "Teleported to your home" + (args.length > 1 ? " called " + args[1] : "") + "!");
        } else
            player.sendMessage("You don't have a home" + (args.length > 1 ? " called " + args[1] : "") + "!");
    }
}
