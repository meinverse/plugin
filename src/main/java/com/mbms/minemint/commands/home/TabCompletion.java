package com.mbms.minemint.commands.home;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TabCompletion implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> suggestions = new ArrayList<>();
        if (sender instanceof Player player) {
            if (args.length == 1) {
                suggestions.add("set");
                suggestions.add("del");
                suggestions.add("tp");
            } else if (args.length == 2 && (new TpCommand().isThisCommand(args[0]) || new DelCommand().isThisCommand(args[0]))) {
                Set<NamespacedKey> keys = player.getPersistentDataContainer().getKeys();
                for (NamespacedKey key : keys)
                    if (key.getKey().startsWith("home-")) suggestions.add(key.getKey().substring("home-".length()));
            }
        }
        return suggestions;
    }
}