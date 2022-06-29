package cc.zjlsx.skywalls.commands.subcommands;

import cc.zjlsx.skywalls.Main;
import cc.zjlsx.skywalls.commands.base.SubCommand;
import cc.zjlsx.skywalls.enums.Permission;
import org.bukkit.entity.Player;

public class CreateArenaCommand extends SubCommand {
    private final Main plugin;
    public CreateArenaCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "createArena";
    }

    @Override
    public String getDescription() {
        return "创建一个新的地图";
    }

    @Override
    public String getSyntax() {
        return "/sw createArena <name>";
    }

    @Override
    public String getPermission() {
        return Permission.Admin.getPermission();
    }

    @Override
    public boolean requiresPlayer() {
        return true;
    }

    @Override
    public void execute(Player sender, String[] args) {

    }
}
