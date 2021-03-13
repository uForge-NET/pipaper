package net.uforge.mc.pl.pipaper.events;

import net.uforge.mc.pl.pipaper.PaperHandler;
import net.uforge.mc.pl.pipaper.PiPaper;
import net.uforge.mc.pl.pipaper.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class PaperEvents implements Listener {

    private final PiPaper core = PiPaper.getPlugin(PiPaper.class);

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if(event.getItem() != null) {
            Player player = event.getPlayer();
            ItemStack item = event.getItem();

            for(Map.Entry entry : PaperHandler.papers.entrySet()) {
                ItemStack entryItem = (ItemStack) entry.getValue();
                ItemMeta entryMeta = entryItem.getItemMeta();

                if(item.getItemMeta().equals(entryMeta)) {
                    for(String command : core.getConfig().getStringList("papers." + entry.getKey() + ".commands")) {
                        core.getServer().dispatchCommand(core.getServer().getConsoleSender(), command.replace("{sender}", player.getName()));
                        if(core.getConfig().getBoolean("papers." + entry.getKey() + ".removeAfterUse")) {
                            player.getInventory().remove(item);
                        }
                    }
                }
            }
        }
    }

}
