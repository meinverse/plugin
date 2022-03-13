package com.mbms.minemint.commands;

import com.mbms.minemint.types.NasaResponse;
import com.mbms.minemint.utils.Http;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetNasaCommand implements CommandExecutor {
    private static final String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            NasaResponse nasa = Http.get(NASA_URL, NasaResponse.class);
            assert nasa != null;
            player.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_AQUA + "Data from NASA:");
            player.sendMessage("Title: " + nasa.getTitle());
            player.sendMessage(nasa.getExplanation());
            player.sendMessage(nasa.getMedia_type());
            player.sendMessage(nasa.getUrl());
            player.sendMessage(nasa.getHdurl());
            player.sendMessage(nasa.getService_version());
            player.sendMessage(nasa.getDate());
            player.sendMessage(nasa.getCopyright());
            player.sendMessage("Source: " + NASA_URL);
        }
        return true;
    }
}
