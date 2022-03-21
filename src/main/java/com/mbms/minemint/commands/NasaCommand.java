package com.mbms.minemint.commands;

import com.mbms.minemint.types.NasaResponse;
import com.mbms.minemint.utils.http.Http;
import com.mbms.minemint.utils.http.ParsedResponse;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NasaCommand implements CommandExecutor {
    private static final String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {

            ParsedResponse<NasaResponse> nasa = Http.request("GET", NASA_URL, NasaResponse.class, null);
            assert nasa != null;
            NasaResponse data = nasa.getParsedJsonData();
            assert data != null;

            player.sendMessage(Component.text("Data from NASA:").color(NamedTextColor.DARK_AQUA).decorate(TextDecoration.BOLD));
            player.sendMessage("Title: " + data.getTitle());
            player.sendMessage(data.getExplanation());
            player.sendMessage(data.getMedia_type());
            player.sendMessage(data.getUrl());
            player.sendMessage(data.getHdurl());
            player.sendMessage(data.getService_version());
            player.sendMessage(data.getDate());
            player.sendMessage(data.getCopyright());
            player.sendMessage("Source: " + NASA_URL);
        }
        return true;
    }
}
