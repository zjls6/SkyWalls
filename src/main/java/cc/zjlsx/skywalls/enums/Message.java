package cc.zjlsx.skywalls.enums;

import net.md_5.bungee.api.ChatColor;

public enum Message {
    Enable("%prefix% &a插件已开启"),
    Disable("%prefix% &c插件已关闭"),
    Player_Only("&c你不能在控制台执行此命令"),
    No_Permission("&c你没有执行此命令的权限"),
    Player_Not_Online("&c该玩家不在线"),
    Reload_Plugin("&a插件配置重载成功");

    private final String configPath;
    private String message;

    Message(String message) {
        this.message = format(message);
        this.configPath = "messages." + name().toLowerCase().replace("_", "-");
    }

    Message(String message, String configPath) {
        this.message = format(message);
        this.configPath = "messages." + configPath;
    }

    public String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public String getConfigPath() {
        return configPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = format(message);
    }

}
