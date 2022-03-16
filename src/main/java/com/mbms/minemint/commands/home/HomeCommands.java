package com.mbms.minemint.commands.home;

import com.mbms.minemint.utils.CommandManager;
import com.mbms.minemint.utils.SubCommand;

public class HomeCommands extends CommandManager {
    public HomeCommands() {
        super(new SubCommand[]{new SetHomeCommand(), new TpCommand(), new DelCommand()});
    }
}
