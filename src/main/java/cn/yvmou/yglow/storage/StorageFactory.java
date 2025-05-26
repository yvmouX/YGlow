package cn.yvmou.yglow.storage;

import cn.yvmou.yglow.YGlow;

public class StorageFactory {
    public static GlowStorage createStorage(YGlow plugin) {
        String storageType = plugin.getConfig().getString("storage.type", "sqlite").toLowerCase();

        switch (storageType) {
            case "mysql":
                return new MySQLGlowStorage(plugin);
            case "yaml":
                return new YamlGlowStorage(plugin);
            case "sqlite":
            default:
                return new SQLiteGlowStorage(plugin);
        }
    }
}
