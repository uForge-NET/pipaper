package net.uforge.mc.pl.pipaper.commands;

import net.uforge.mc.pl.pipaper.PiPaper;
import net.uforge.mc.pl.pipaper.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaperList implements CommandInterface {

    private static final PiPaper core = PiPaper.getPlugin(PiPaper.class);
    private static final Utils u = new Utils();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(u.colorize("&9&lPiPaper - Paper List:"));
        for (String paper : core.getConfig().getConfigurationSection("papers").getKeys(false)) {
            player.sendMessage(u.colorize("&e- " + paper));
        }
        return false;
    }
}
