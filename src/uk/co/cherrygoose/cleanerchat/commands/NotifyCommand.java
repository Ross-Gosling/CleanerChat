package uk.co.cherrygoose.cleanerchat.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import uk.co.cherrygoose.cleanerchat.Main;
import uk.co.cherrygoose.cleanerchat.systems.Notification;

public class NotifyCommand 
{
	public static boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
	{		
    	// If sender is a player
		if(sender instanceof Player) 
		{
			// Casts sender to Player
			Player player = (Player) sender;

			// Toggles player notification mode
			Notification.toggleNotify(player);
			
			// Logs to console
			Bukkit.getLogger().info("["+Main.pluginName+"] " + player.getName() + ": /notify");

			// Sends player feedback
			player.sendMessage(ChatColor.WHITE + "Chat notifications set to " + Notification.getNotify(player));
			return true;
		}
		
		// If sender is the console
		if(sender instanceof ConsoleCommandSender) 
		{
			//ConsoleCommandSender console = (ConsoleCommandSender) sender;
		}
		
		// If sender is a command block
		if(sender instanceof BlockCommandSender) 
		{
			//BlockCommandSender cmdBlock = (BlockCommandSender) sender;
		}
				
		return false;
	}
	
	public static List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) 
	{
		return null;
	}
}
