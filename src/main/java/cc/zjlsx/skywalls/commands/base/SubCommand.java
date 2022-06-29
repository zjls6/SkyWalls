package cc.zjlsx.skywalls.commands.base;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * A subcommand class that we'll be using to extend on our commands
 */
public abstract class SubCommand {

    /**
     * @return The command's name
     */
    public abstract String getName();

    /**
     * @return The command's description
     */
    public abstract String getDescription();

    /**
     * @return The command's syntax
     */
    public abstract String getSyntax();

    /**
     * @return The permission required in order to run this command
     */
    public abstract String getPermission();

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(getPermission());
    }

    /**
     * @return Whether this command requires a player to execute
     */
    public abstract boolean requiresPlayer();

    /**
     * The method that will be run once the command is executed
     *
     * @param sender the console sender that executed the command
     * @param args  subcommand arguments
     */
    public void execute(CommandSender sender, String[] args){

    }

    /**
     * The method that will be run once the command is executed by player
     * @param player the player that executed this command
     * @param args subcommand arguments
     */
    public void execute(Player player, String[] args){

    }
}