package me.yaki.customcfgmessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import sun.security.krb5.Config;

import javax.security.auth.login.Configuration;

public final class CustomCFGMessage extends JavaPlugin {

    private static JavaPlugin plugin;

    public static JavaPlugin getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        CustomConfig.setup();
        CustomConfig.get().addDefault("Message", "Приветствую на пидорском серве");
        CustomConfig.get().addDefault("MssChat", "Ты ещё тут еблантяй?");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();

        Bukkit.getPluginManager().registerEvents(new Message(), this);
        String message = plugin.getConfig().getString("time");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(CustomConfig.get().getString("MssChat"));
            }
        }, plugin.getConfig().getInt("time"), plugin.getConfig().getInt("time"));
    }
}