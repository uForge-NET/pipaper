package net.uforge.mc.pl.pipaper;

import java.util.List;

public class Config {

    private static final PiPaper core = PiPaper.getPlugin(PiPaper.class);

    // @s: Config Variables
    public static String interactType;
    // @e: Config Variables

    public static void load() {
        core.getConfig().options().copyDefaults(true);
        core.saveConfig();
        setConfigVariables();
    }

    public static void reload() {
        core.reloadConfig();
        setConfigVariables();
    }

    private static void setConfigVariables() {
        interactType = Config.getString("settings.interactType");
    }

    public static String getString(String key) {
        return core.getConfig().getString(key);
    }

    public static Boolean getBoolean(String key) {
        return core.getConfig().getBoolean(key);
    }

    public static List<String> getStringList(String key) {
        return core.getConfig().getStringList(key);
    }

}
