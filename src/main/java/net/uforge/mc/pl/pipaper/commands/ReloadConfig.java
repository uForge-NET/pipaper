package net.uforge.mc.pl.pipaper.commands;

import net.uforge.mc.pl.pipaper.Config;
import net.uforge.mc.pl.pipaper.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ReloadConfig implements CommandInterface {

    private final Utils u = new Utils();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Config.reload();
        sender.sendMessage(u.INFO + "Plugin reloaded!");
        return false;
    }
}
