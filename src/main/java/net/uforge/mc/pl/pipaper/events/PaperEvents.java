package net.uforge.mc.pl.pipaper.events;

import net.uforge.mc.pl.pipaper.Config;
import net.uforge.mc.pl.pipaper.PaperHandler;
import net.uforge.mc.pl.pipaper.PiPaper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class PaperEvents implements Listener {

    private final PiPaper core = PiPaper.getPlugin(PiPaper.class);

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getItem() != null) {
            Player player = event.getPlayer();
            ItemStack item = event.getItem();

            if(Config.interactType.equals("right") && !event.getAction().equals(Action.RIGHT_CLICK_AIR) && !event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                event.setCancelled(true);
            } else if(Config.interactType.equals("left") && !event.getAction().equals(Action.LEFT_CLICK_AIR) && !event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                event.setCancelled(true);
            } else {
                for(Map.Entry entry : PaperHandler.papers.entrySet()) {
                    ItemStack entryItem = (ItemStack) entry.getValue();
                    ItemMeta entryMeta = entryItem.getItemMeta();

                    if(item.getItemMeta().equals(entryMeta)) {
                        for(String command : core.getConfig().getStringList("papers." + entry.getKey() + ".commands")) {
                            core.getServer().dispatchCommand(core.getServer().getConsoleSender(), command.replace("{player}", player.getName()));
                            if(core.getConfig().getBoolean("papers." + entry.getKey() + ".removeAfterUse")) {
                                if(item.getAmount() == 1) {
                                    player.getInventory().remove(item);
                                } else {
                                    item.setAmount(item.getAmount() - 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
