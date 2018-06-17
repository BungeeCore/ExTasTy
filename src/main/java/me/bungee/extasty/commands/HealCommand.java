package me.bungee.extasty.commands;

import me.bungee.extasty.Extasty;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    private Extasty instance;

    public HealCommand(Extasty instance) {
        this.instance = instance;
        Bukkit.getPluginCommand("heal").setPermission("heal.use");
        Bukkit.getPluginCommand("heal").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cDu musst ein Spieler sein!");
            return true;
        }

        final Player p = (Player) sender;

        if (args.length == 0) {
            Bukkit.getScheduler().scheduleAsyncDelayedTask(instance, new Runnable() {
                public void run() {
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.setSaturation(20);
                    p.sendMessage("§aDu wurdest geheilt!");
                }
            });
        } else {
            final Player target = Bukkit.getPlayer(args[0]);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(instance, new Runnable() {
                public void run() {
                    target.setHealth(20);
                    target.setFoodLevel(20);
                    target.setSaturation(20);
                    target.sendMessage("§aDu wurdest von §4" + p.getName() + " §ageheilt!");
                }
            });
        }
        return false;
    }
}
