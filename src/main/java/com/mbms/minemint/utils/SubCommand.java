package com.mbms.minemint.utils;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    //name of the subcommand ex. /ban
    public abstract String[] getNames();

    //ex. "This is a command that bans a player."
    public abstract String getDescription();

    //How to use command ex. /ban <player>
    public abstract String getSyntax();

    //code for the subcommand
    public abstract void perform(Player player, String[] args);

    public boolean isThisCommand(String command) {
        for (String name : getNames())
            if (command.equalsIgnoreCase(name))
                return true;
        return false;
    }

}
