package cc.zjlsx.skywalls.commands.storage;

import cc.zjlsx.skywalls.commands.storage.base.BaseYamlConfigProvider;
import cc.zjlsx.skywalls.enums.Message;

public class ConfigManager extends BaseYamlConfigProvider {

    @Override
    public void load() {
        reload();
        // 生成默认的消息
        config.addDefault("messages.prefix","&7[&6Sky&cWalls&7]");
        for (Message message : Message.values()) {
            config.addDefault(message.getConfigPath(), message.getMessage());
        }
        config.options().copyDefaults(true);
        save();
        //加载消息
        loadMessages();
    }

    private void loadMessages() {
        for (Message message : Message.values()) {
            String prefix = config.getString("messages.prefix");
            String configPath = message.getConfigPath();
            if (configPath == null) {
                getPlugin().getLogger().severe("无法获取消息 " + message + " 请尝试删除配置文件后重启重新生成");
                continue;
            }
            String string = config.getString(configPath);
            if (string == null) {
                getPlugin().getLogger().severe("无法获取消息 " + message.getConfigPath() + " 请尝试删除配置文件后重启重新生成");
                continue;
            }
            message.setMessage(string.replace("%prefix%", prefix));
        }
    }
}
