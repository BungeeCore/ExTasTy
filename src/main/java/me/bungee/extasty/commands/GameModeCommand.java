package me.bungee.extasty.commands;

import me.bungee.extasty.Extasty;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandExecutor {

    private Extasty instance;

    public GameModeCommand(Extasty instance) {
        this.instance = instance;
        Bukkit.getPluginCommand("gm").setPermission("gm.use");
        Bukkit.getPluginCommand("gm").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cDu musst ein Spieler sein!");
            return true;
        }

        final Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage("§cBitte nutze /gm <0|1|2|3>");
            return true;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("0")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage("§aDein Gamemode wurde zum Surivalmode geändert");
            }
            if (args[0].equalsIgnoreCase("1")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage("§aDein Gamemode wurde zum Creativemode geändert");
            }
            if (args[0].equalsIgnoreCase("2")) {
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage("§aDein Gamemode wurde zum Adventuremode geändert");
            }
            if (args[0].equalsIgnoreCase("3")) {
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage("§aDein Gamemode wurde zum Specatormode geändert");
            }
        }

        return false;
    }
}
