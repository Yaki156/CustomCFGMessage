package me.yaki.customcfgmessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Message implements Listener {

    @EventHandler
   void OnJPS(PlayerJoinEvent event) {

        if (event.getPlayer() instanceof  Player){
            Player player = event.getPlayer();
            player.sendTitle(CustomConfig.get().getString("Message"), null , 10,10,10);
            }
        }

    }


