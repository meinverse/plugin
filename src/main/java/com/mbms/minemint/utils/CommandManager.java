package com.mbms.minemint.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandManager implements CommandExecutor {

    private final SubCommand[] subcommands;

    public CommandManager(SubCommand[] subcommands) {
        this.subcommands = subcommands;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        boolean wasFound = false;
        if (sender instanceof Player player) {
            if (args.length > 0) {
                for (SubCommand subcommand : subcommands)
                    for (String alias : subcommand.getNames())
                        if (alias.equalsIgnoreCase(args[0])) {
                            wasFound = true;
                            subcommand.perform(player, args);
                        }
            }
            if (!wasFound) printHelp(player);
        }
        return true;
    }

    private void printHelp(@NotNull Player player) {
        player.sendMessage("--------------------------------");
        for (SubCommand subcommand : subcommands)
            player.sendMessage(subcommand.getSyntax() + " - " + subcommand.getDescription());
        player.sendMessage("--------------------------------");

    }
}
