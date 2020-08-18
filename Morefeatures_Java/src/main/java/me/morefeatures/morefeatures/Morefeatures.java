package me.morefeatures.morefeatures;

import me.morefeatures.morefeatures.commands.setname;
import org.bukkit.plugin.java.JavaPlugin;

public final class Morefeatures extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[Morefeatures] register commands");
        getCommand("setname").setExecutor(new setname());

        System.out.println("[Morefeatures] register events");

        System.out.println("[Morefeatures] is on Enable");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
