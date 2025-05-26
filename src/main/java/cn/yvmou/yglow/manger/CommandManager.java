package cn.yvmou.yglow.manger;

import cn.yvmou.yglow.YGlow;
import cn.yvmou.yglow.cmds.main.MainCommandHandler;
import cn.yvmou.yglow.cmds.main.MainTabCompleter;

import java.util.Objects;

public class CommandManager {
    private final YGlow plugin;

    public CommandManager(YGlow plugin) {
        this.plugin = plugin;
    }

    /**
     * Registers all commands
     */
    public void registerCommands() {
        Objects.requireNonNull(plugin.getCommand("yglow")).setExecutor(new MainCommandHandler(plugin));
        Objects.requireNonNull(plugin.getCommand("yglow")).setTabCompleter(new MainTabCompleter(plugin));
    }

}
