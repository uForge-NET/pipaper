package net.uforge.mc.pl.pipaper.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {

    public String INFO = ChatColor.AQUA + "[PiPaper/" + ChatColor.GREEN + "INFO" + ChatColor.AQUA + "]: " + ChatColor.GREEN;
    public String WARN = ChatColor.AQUA + "[PiPaper/" + ChatColor.YELLOW + "WARN" + ChatColor.AQUA + "]: " + ChatColor.YELLOW;
    public String ERR = ChatColor.AQUA + "[PiPaper/" + ChatColor.RED + "ERR" + ChatColor.AQUA + "]: " + ChatColor.RED;

    public void sendConsole(String prefix, String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + msg);
    }

    public void sendConsole(String msg) {
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
