package cn.yvmou.yglow.cmds.main.sub;

import cn.yvmou.yglow.YGlow;
import cn.yvmou.yglow.cmds.SubCommand;
import cn.yvmou.yglow.utils.CommandUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class ToggleCmd implements SubCommand {
    private final YGlow plugin;
    public ToggleCmd(YGlow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "这个命令只能由玩家执行！");
            return false;
        }
        if (!hasPermission(sender)) {
            CommandUtils.throwPermissionError(sender);
            return false;
        }

        glowToggle((Player) sender);
        return true;
    }

    @Override
    public String getUsage() {
        return "/yglow toggle";
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission("yglow.toggle");
    }


    private void glowToggle(Player player) {
        UUID playerId = player.getUniqueId();
        boolean currentlyGlowing = plugin.getGlowStorage().isGlowing(playerId);

        if (currentlyGlowing) {
            player.removePotionEffect(PotionEffectType.GLOWING);
            plugin.getGlowStorage().setGlowing(playerId, false);
            player.sendMessage(ChatColor.RED + "发光效果已移除!");
        } else {
            player.addPotionEffect(
                    new PotionEffect(
                            PotionEffectType.GLOWING,
                            Integer.MAX_VALUE,
                            0,
                            false,
                            false,
                            true
                    )
            );
            plugin.getGlowStorage().setGlowing(playerId, true);
            player.sendMessage(ChatColor.RED + "你获得了发光效果");
        }
    }
}