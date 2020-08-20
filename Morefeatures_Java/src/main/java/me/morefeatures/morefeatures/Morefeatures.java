package me.morefeatures.morefeatures;

import me.morefeatures.morefeatures.commands.setname;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public final class Morefeatures extends JavaPlugin {

    private static Economy econ = null;

    @Override

    public void onEnable() {
        // Plugin startup logic
        System.out.println("[Morefeatures] Detection depend");
        if (!setupEconomy() ) {
            System.out.println(ChatColor.RED+"ServerNotInstallEconomyPlugins!");
        }

        System.out.println("[Morefeatures] register commands");
        getCommand("setname").setExecutor(new setname());

        System.out.println("[Morefeatures] register events");

        System.out.println("[Morefeatures] is on Enable");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
