package cn.yvmou.yglow.cmds.main.sub;

import cn.yvmou.yglow.YGlow;
import cn.yvmou.yglow.cmds.SubCommand;
import cn.yvmou.yglow.utils.CommandUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCmd implements SubCommand {
    private final YGlow plugin;

    public ListCmd(YGlow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!hasPermission(sender)) {
            CommandUtils.throwPermissionError(sender);
            return false;
        }

        sender.sendMessage(ChatColor.GOLD + "===== 发光玩家列表 =====");

        int count = 0;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (plugin.getGlowStorage().isGlowing(player.getUniqueId())) {
                sender.sendMessage(ChatColor.GREEN + "- " + player.getName());
                count++;
            }
        }

        if (count == 0) {
            sender.sendMessage(ChatColor.GRAY + "当前没有玩家处于发光状态");
        } else {
            sender.sendMessage(ChatColor.GOLD + "总计: " + count + " 个玩家");
        }

        return true;
    }


    @Override
    public String getUsage() {
        return "";
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return false;
    }
}
