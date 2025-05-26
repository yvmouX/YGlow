package cn.yvmou.yglow.events;

import cn.yvmou.yglow.YGlow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener {
    private final YGlow plugin;

    public PlayerListener(YGlow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (plugin.getGlowStorage().isGlowing(player.getUniqueId())) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.GLOWING,
                    Integer.MAX_VALUE,
                    0,
                    false,
                    false,
                    true
            ));
        }
    }
}
