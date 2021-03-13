package net.uforge.mc.pl.pipaper.commands;

import net.uforge.mc.pl.pipaper.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PIPAPER implements CommandInterface{

    private static final Utils u = new Utils();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        player.sendMessage(u.colorize("&9&lPiPaper - Commands:"));
        player.sendMessage(u.colorize("&e- list"));
        player.sendMessage(u.colorize("&e- give {paperId}"));

        return false;
    }
}
