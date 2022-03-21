package com.mbms.minemint.commands.home;

import com.mbms.minemint.MineMint;
import com.mbms.minemint.utils.SubCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class DelCommand extends SubCommand {
    @Override
    public String[] getNames() {
        return new String[]{"del", "delete", "remove"};
    }

    @Override
    public String getDescription() {
        return "Delete your home";
    }

    @Override
    public String getSyntax() {
        return "/home del <home name>(optional)";
    }

    @Override
    public void perform(@NotNull Player player, String @NotNull [] args) {
        String name = "home-" + (args.length > 1 ? args[1] : "home");
        NamespacedKey namespaceKey = new NamespacedKey(MineMint.getPlugin(), name);
        PersistentDataContainer data = player.getPersistentDataContainer();
        String homeNamePart = Utils.getHomeNamePart(args);

        if (data.has(namespaceKey, PersistentDataType.STRING)) {
            data.remove(namespaceKey);
            player.sendMessage(Component.text("Deleted your home" + homeNamePart + "!").color(NamedTextColor.GREEN));
        } else
            player.sendMessage(Component.text("You don't have a home" + homeNamePart + "!").color(NamedTextColor.RED));
    }
}
