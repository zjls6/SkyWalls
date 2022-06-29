package cc.zjlsx.skywalls.commands;

import cc.zjlsx.skywalls.Main;
import cc.zjlsx.skywalls.commands.base.SubCommand;
import cc.zjlsx.skywalls.commands.subcommands.CreateArenaCommand;
import cc.zjlsx.skywalls.enums.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SkyWallsCommand implements TabExecutor {
    private final List<SubCommand> subCommands = new ArrayList<>();

    public SkyWallsCommand(Main plugin) {
        subCommands.add(new CreateArenaCommand(plugin));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sendHelpMessage(sender);
            return true;
        }
        String subCommandName = args[0];
        Optional<SubCommand> optionalSubCommand = subCommands.stream().filter(subCommand -> subCommand.getName().equals(subCommandName)).findFirst();
        if (!optionalSubCommand.isPresent()) {
            sendHelpMessage(sender);
            return true;
        }
        SubCommand subCommand = optionalSubCommand.get();
        if (!subCommand.hasPermission(sender)) {
            sender.sendMessage(Message.No_Permission.getMessage());
            return true;
        }
        if (subCommand.requiresPlayer()) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Message.Player_Only.getMessage());
                return true;
            }
            subCommand.execute((Player) sender, args);
            return true;
        }
        subCommand.execute(sender, args);
        return true;
    }

    private void sendHelpMessage(CommandSender sender) {
        sender.sendMessage("");
        sender.sendMessage("可用指令");
        sender.sendMessage("");

        subCommands.stream().filter(subCommand -> subCommand.hasPermission(sender))
                .forEach(subCommand -> sender.sendMessage(
                        ChatColor.GOLD + subCommand.getSyntax() + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + subCommand.getDescription()));

        sender.sendMessage("");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return subCommands.stream().filter(subCommand -> subCommand.hasPermission(sender)).map(SubCommand::getName).collect(Collectors.toList());
        }
        if (args.length > 1) {
            return Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList());
        }
        return null;
    }


}
