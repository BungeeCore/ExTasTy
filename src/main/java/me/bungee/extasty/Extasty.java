package me.bungee.extasty;

import me.bungee.extasty.commands.GameModeCommand;
import me.bungee.extasty.commands.HealCommand;
import me.bungee.extasty.listener.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Extasty extends JavaPlugin {

    private static Extasty instance;

    @Override
    public void onEnable() {
        setInstance(this);
        initListeners();
        initCommands();
    }

    @Override
    public void onDisable() {
        setInstance(null);
    }

    private void initListeners() {
        new PlayerJoinListener(getInstance());
    }

    private void initCommands() {
        new HealCommand(getInstance());
        new GameModeCommand(getInstance());
    }

    public static void setInstance(Extasty instance) {
        Extasty.instance = instance;
    }

    public static Extasty getInstance() {
        return instance;
    }
}
