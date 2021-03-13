package net.uforge.mc.pl.pipaper;

import net.uforge.mc.pl.pipaper.commands.CommandHandler;
import net.uforge.mc.pl.pipaper.commands.GivePaper;
import net.uforge.mc.pl.pipaper.commands.PIPAPER;
import net.uforge.mc.pl.pipaper.commands.PaperList;
import net.uforge.mc.pl.pipaper.events.PaperEvents;
import net.uforge.mc.pl.pipaper.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.print.Paper;

public class PiPaper extends JavaPlugin {

    private final Utils u = new Utils();

    @Override
    public void onEnable() {
        registerEvents();
        loadConfig();
        PaperHandler.generatePapers();
        registerCommands();

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
        u.sendConsole(u.INFO, u.colorize("&cPlugin has been disabled!"));
    }

    private void registerCommands() {
        CommandHandler handler = new CommandHandler();
        handler.register("pipaper", new PIPAPER());
        handler.register("give", new GivePaper());
        handler.register("list", new PaperList());
        getCommand("pipaper").setExecutor(handler);
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new PaperEvents(), this);
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        u.sendConsole(u.INFO, "Config has been loaded.");
    }

}
