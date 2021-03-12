package net.uforge.mc.pl.pipaper;

import net.uforge.mc.pl.pipaper.events.PlayerEvents;
import net.uforge.mc.pl.pipaper.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PiPaper extends JavaPlugin {

    private final Utils u = new Utils();

    @Override
    public void onEnable() {
        registerEvents();
        u.sendConsole(u.colorize("\n&e" +
                "         ______                                  ____  _ ____                       \n" +
                "  __  __/ ____/___  _________ ____              / __ \\(_) __ \\____ _____  ___  _____\n" +
                " / / / / /_  / __ \\/ ___/ __ `/ _ \\   ______   / /_/ / / /_/ / __ `/ __ \\/ _ \\/ ___/\n" +
                "/ /_/ / __/ / /_/ / /  / /_/ /  __/  /_____/  / ____/ / ____/ /_/ / /_/ /  __/ /    \n" +
                "\\__,_/_/    \\____/_/   \\__, /\\___/           /_/   /_/_/    \\__,_/ .___/\\___/_/     \n" +
                "                      /____/                                    /_/                 " +
                ""));
        u.sendConsole(u.INFO, "Plugin has been activated!");
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {

    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        u.sendConsole(u.INFO, "Config has been loaded.");
    }

}
