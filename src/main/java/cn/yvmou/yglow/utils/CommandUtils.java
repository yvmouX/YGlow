package cn.yvmou.yglow.utils;

import cn.yvmou.yglow.cmds.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.awt.*;
import java.util.Map;

public final class CommandUtils {
    public static void throwUsageError(CommandSender sender, Map<String, SubCommand> subCommands) {
        sender.sendMessage(ChatColor.RED + "§c用法错误！可用子命令：");
        for (SubCommand subCommand : subCommands.values()) {
            sender.sendMessage(subCommand.getUsage());
        }

    }

    public static void throwPermissionError(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "你没有权限使用这个命令!");
    }

}
