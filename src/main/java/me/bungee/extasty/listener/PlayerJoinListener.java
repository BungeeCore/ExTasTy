package me.bungee.extasty.listener;

import me.bungee.extasty.Extasty;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private Extasty instance;

    public PlayerJoinListener(Extasty instance) {
        this.instance = instance;
        Bukkit.getPluginManager().registerEvents(this, instance);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        Bukkit.getScheduler().scheduleAsyncDelayedTask(instance, new Runnable() {

            public void run() {
                if (!p.hasPlayedBefore()) {
                    p.sendTitle("§6Willkommen, §9" + p.getName(), "§7Du bist das erstemal gejoint!");
                }
            }
        });
    }
}
