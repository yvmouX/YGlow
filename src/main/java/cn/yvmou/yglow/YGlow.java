package cn.yvmou.yglow;

import cn.yvmou.yglow.events.PlayerListener;
import cn.yvmou.yglow.expansion.PapiExpansion;
import cn.yvmou.yglow.storage.GlowStorage;
import cn.yvmou.yglow.storage.StorageFactory;
import cn.yvmou.yglow.manger.CommandManager;
import com.tcoded.folialib.FoliaLib;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class YGlow extends JavaPlugin {
    public static FoliaLib foliaLib;
    private GlowStorage glowStorage;

    public static FoliaLib getFoliaLib() {return foliaLib;}


    @Override
    public void onEnable() {
        foliaLib = new FoliaLib(this);
        // 保存默认配置
        saveDefaultConfig();

        // 初始化存储系统
        glowStorage = StorageFactory.createStorage(this);
        glowStorage.init();
        // 注册命令和事件
        new CommandManager(this).registerCommands();
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) { //
            new PapiExpansion(this).register(); //
        }

    }

    @Override
    public void onDisable() {
        // 关闭存储系统
        if (glowStorage != null) {
            glowStorage.shutdown();
        }
    }

    public GlowStorage getGlowStorage() {
        return glowStorage;
    }
}
