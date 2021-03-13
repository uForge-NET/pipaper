package net.uforge.mc.pl.pipaper.commands;

import net.uforge.mc.pl.pipaper.PaperHandler;
import net.uforge.mc.pl.pipaper.PiPaper;
import net.uforge.mc.pl.pipaper.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GivePaper implements CommandInterface {

    private final PiPaper core = PiPaper.getPlugin(PiPaper.class);
    private final Utils u = new Utils();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = null;
        try {
            player = core.getServer().getPlayer(args[1]);
            if(player.isOnline()) {
                try {
                    if(Integer.parseInt(args[3]) <= 0 || args[3] == null) {
                        sender.sendMessage(u.colorize("&cPlease enter count."));
                    } else {
                        for(int i = 0; i < Integer.parseInt(args[3]); i++) {
                            player.getInventory().addItem(PaperHandler.papers.get(args[2]));
                        }
                    }
                } catch (Exception ex) {
                    sender.sendMessage(u.colorize("&cPaper not found."));
                }
            } else {
                sender.sendMessage(u.colorize("&cPlayer not found."));
            }
        } catch (Exception ex) {
            sender.sendMessage(u.colorize("&cPlayer not found."));
        }

        return false;
    }
}
