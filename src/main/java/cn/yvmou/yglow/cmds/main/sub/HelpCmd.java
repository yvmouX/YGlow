package cn.yvmou.yglow.cmds.main.sub;

import cn.yvmou.yglow.YGlow;
import cn.yvmou.yglow.cmds.SubCommand;
import cn.yvmou.yglow.utils.CommandUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCmd implements SubCommand {
    private final YGlow plugin;

    public HelpCmd(YGlow plugin) {this.plugin = plugin;}

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!hasPermission(sender)) {
            CommandUtils.throwPermissionError(sender);
            return false;
        }
        seedHelpMessage(sender);
        return true;
    }

    @Override
    public String getUsage() {
        return "/yglow help";
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission("yglow.help");
    }


    public void seedHelpMessage(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "YGlow 帮助");
        sender.sendMessage(ChatColor.WHITE + "/yglow toggle");
        sender.sendMessage(ChatColor.WHITE + "/yglow help");
        sender.sendMessage(ChatColor.WHITE + "/yglow reload");
    }


}
