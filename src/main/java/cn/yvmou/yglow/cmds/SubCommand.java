package cn.yvmou.yglow.cmds;

import org.bukkit.command.CommandSender;

public interface SubCommand {
    /**
     * 执行子命令逻辑
     *
     * @param sender Command sender
     * @param args Arguments passed to the command
     * @return true if successful, false otherwise
     */
    boolean execute(CommandSender sender, String[] args);

    /**
     * 提供子命令的使用说明
     *
     * @return A string representing command usage
     */
    String getUsage();

    /**
     * 检查发送者是否有权限使用子命令.
     *
     * @param sender The command sender
     * @return True if the sender has permission
     */
    boolean hasPermission(CommandSender sender);
}

