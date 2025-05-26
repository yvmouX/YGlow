package cn.yvmou.yglow.cmds.main;

import cn.yvmou.yglow.YGlow;
import cn.yvmou.yglow.cmds.SubCommand;
import cn.yvmou.yglow.cmds.main.sub.HelpCmd;
import cn.yvmou.yglow.cmds.main.sub.ListCmd;
import cn.yvmou.yglow.cmds.main.sub.ReloadCmd;
import cn.yvmou.yglow.cmds.main.sub.ToggleCmd;
import cn.yvmou.yglow.utils.CommandUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MainCommandHandler implements CommandExecutor {
    private final YGlow plugin;
    private final Map<String, SubCommand> commands = new HashMap<>();

    public MainCommandHandler(YGlow plugin) {
        this.plugin = plugin;

        commands.put("help", new HelpCmd(plugin));
        commands.put("reload", new ReloadCmd(plugin));
        commands.put("toggle", new ToggleCmd(plugin));
        commands.put("list", new ListCmd(plugin));
    }




    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sendVersionMessage(sender);
            return true;
        }

        SubCommand subCommand = commands.get(args[0]);

        if (subCommand == null) {
            //sendVersionMessage(sender);
            CommandUtils.throwUsageError(sender, commands);
            return true;
        }

        return subCommand.execute(sender, args);
    }

    private void sendVersionMessage(CommandSender sender) {
        sender.sendMessage("YGlow version: " + plugin.getDescription().getVersion());
    }
}
