package com.mbms.minemint.commands;

import com.mbms.minemint.types.GreetRequest;
import com.mbms.minemint.utils.http.Http;
import com.mbms.minemint.utils.http.ParsedResponse;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GreetCommand implements CommandExecutor {
    private static final String DUMMY_API_URL = "https://dummy-api.deta.dev/greeting";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            GreetRequest payload = new GreetRequest(player.getName());
            ParsedResponse<String> post = Http.request("POST", DUMMY_API_URL, String.class, payload);
            assert post != null;
            String data = post.getParsedStringData();
            assert data != null;
            if (post.getIsSuccess())
                player.sendMessage("\n" + data);
        }
        return true;
    }
}
