package cn.yvmou.yglow.cmds.main.sub;

import cn.yvmou.yglow.YGlow;
import cn.yvmou.yglow.cmds.SubCommand;
import cn.yvmou.yglow.utils.CommandUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ReloadCmd implements SubCommand {
    private final YGlow plugin;

    public ReloadCmd(YGlow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!hasPermission(sender)) {
            CommandUtils.throwPermissionError(sender);
            return false;
        }
        plugin.reloadConfig();
        sender.sendMessage(ChatColor.GREEN + "成功重载插件！");
        return true;
    }

    @Override
    public String getUsage() {
        return "/yglow reload";
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission("yglow.reload");
    }
}
