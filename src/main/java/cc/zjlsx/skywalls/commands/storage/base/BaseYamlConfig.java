package cc.zjlsx.skywalls.commands.storage.base;

import cc.zjlsx.skywalls.Main;

public interface BaseYamlConfig {
    void init(Main plugin, String name);

    void load();

    void reload();

    void save();

}
