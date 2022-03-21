package com.mbms.minemint.commands.home;

public class Utils {
    public static String getHomeNamePart(String[] args) {
        return (args.length > 1 ? " called " + args[1] : "");
    }
}
