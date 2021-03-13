package net.uforge.mc.pl.pipaper;

import net.uforge.mc.pl.pipaper.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaperHandler {

    private static final PiPaper core = PiPaper.getPlugin(PiPaper.class);
    private static final Utils u = new Utils();

    public static HashMap<String, ItemStack> papers = new HashMap<>();

    public static void generatePapers() {
        for (String paper : core.getConfig().getConfigurationSection("papers").getKeys(false)) {
            String base = "papers." + paper + ".";
            ItemStack _paper = new ItemStack(Material.PAPER, 1);
            ItemMeta _paperMeta = _paper.getItemMeta();
            _paperMeta.setDisplayName(u.colorize(core.getConfig().getString(base + "displayName")));
            List<String> lores = new ArrayList<>();
            for(String lore : core.getConfig().getStringList(base + "lores")) {
                lores.add(u.colorize(lore));
            }
            _paperMeta.setLore(lores);
            _paper.setItemMeta(_paperMeta);
            papers.put(paper, _paper);
        }

    }

}
