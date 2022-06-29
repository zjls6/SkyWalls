package cc.zjlsx.skywalls;

import cc.zjlsx.skywalls.commands.SkyWallsCommand;
import cc.zjlsx.skywalls.commands.storage.ConfigManager;
import cc.zjlsx.skywalls.enums.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private final ConsoleCommandSender logger = Bukkit.getConsoleSender();
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        //加载配置文件
        (configManager = new ConfigManager()).init(this, "config");
        // 注册命令
        PluginCommand mainCommand = getCommand("skywalls");
        mainCommand.setExecutor(new SkyWallsCommand(this));
        mainCommand.setTabCompleter(new SkyWallsCommand(this));

        logger.sendMessage(Message.Enable.getMessage());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.sendMessage(Message.Disable.getMessage());
    }
}
