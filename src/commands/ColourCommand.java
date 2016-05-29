package commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import CleanerChat.Main;
import systems.NameColour;
import systems.Utils;

public class ColourCommand {

	public static boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
	{		
    	// If sender is a player
		if(sender instanceof Player) 
		{
			// Casts sender to Player
			Player player = (Player) sender;

			// If there are arguments
			if(args.length != 0)
			{
				// If first arg is "set"
				if(args[0].equalsIgnoreCase("set"))
				{
					// If second arg exists
					if(args.length > 1)
					{
						// Creates list for available colours by name
						ArrayList<String> colourNames = new ArrayList<String>();
						// For all ChatColors
						for(ChatColor colour : ChatColor.values())
						{
							// If colour isn't prohibited
							if(!(colour.equals(ChatColor.BOLD) || colour.equals(ChatColor.ITALIC) || colour.equals(ChatColor.MAGIC) || colour.equals(ChatColor.RESET) || colour.equals(ChatColor.STRIKETHROUGH)|| colour.equals(ChatColor.UNDERLINE)))
							{
								// Adds colour name to list
								colourNames.add(colour.name());
							}
						}
						
						// Logs to console
						Bukkit.getLogger().info("["+Main.pluginName+"] " + player.getName() + ": /colour set " + args[1]);
						
						// If arg is a colour
						if(colourNames.contains(args[1].toUpperCase()))
						{
							// Sets name colour
							NameColour.set(player, ChatColor.valueOf(args[1].toUpperCase()));
							
							// Sends player feedback
							player.sendMessage(ChatColor.WHITE + "Colour set: " + NameColour.get(player) + Utils.capitalise(NameColour.get(player).name()));
		
					    	// Logs to console
					    	Bukkit.getLogger().info("["+Main.pluginName+"] " + player.getName() + " set name colour to " + NameColour.get(player).name());
						}
						// Invalid colour
						else
						{
							// Sends player feedback
							player.sendMessage(ChatColor.RED + "Invalid colour '" + args[1] + "'");
							return true;
						}
					}
					else 
					{
						// Logs to console
						Bukkit.getLogger().info("["+Main.pluginName+"] " + player.getName() + ": /colour set " + args[0]);
						
						// Sends player feedback
						player.sendMessage(ChatColor.RED + "Usage: /colour set <colour>");
						return true;
					}
				}
				else 
				{
					// Logs to console
					Bukkit.getLogger().info("["+Main.pluginName+"] " + player.getName() + ": /colour " + args[0]);
					
					// Sends player feedback
					player.sendMessage(ChatColor.RED + "Usage: /colour set <colour>");
					return true;
				}
			}
			// Else there are no arguments
			else
			{
				// Logs to console
				Bukkit.getLogger().info("["+Main.pluginName+"] " + player.getName() + ": /colour");

				// Sends player feedback
				player.sendMessage(ChatColor.WHITE + "Colour: " + NameColour.get(player) + Utils.capitalise(NameColour.get(player).name()));
				return true;
			}
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
		// If has 1 argument
		if(args.length == 1)
		{
			// Declares array for appropriate arguments to return
			ArrayList<String> returnedArgs = new ArrayList<String>();
			
			// Declares array of valid arguments
			ArrayList<String> validArgs = new ArrayList<String>();
			// Defines valid args
			validArgs.add("set");
						
			// If arg is not empty
			if(!args[0].toString().equals(""))
			{
				// For all validArgs
				for (String validArg : validArgs)
				{
					// If validArg starts with argument
					if(validArg.toLowerCase().startsWith(args[0].toLowerCase()))
					{
						// Adds validArg to list
						returnedArgs.add(validArg);
					}
				}
			}
			// If arg is empty
			else
			{
				// For all validArgs
				for (String validArg : validArgs)
				{
					// If validArg is not null
					if(validArg != null)
					{
						// Adds validArg to list
						returnedArgs.add(validArg);
					}
				}
			}
			
			// Sorts list into alphabetical order
			Collections.sort(returnedArgs);
			
			// Returns list
			return returnedArgs;
		}
		// If has "set" arg and another
		else if (args[0].equalsIgnoreCase("set") && args.length == 2)
		{
			// Declares array for appropriate chat colours
			ArrayList<String> returnedColourNames = new ArrayList<String>();
			// Declares array of disallowed chat colours
			ArrayList<ChatColor> bannedColours = new ArrayList<ChatColor>();
			// Defines banned colours
			bannedColours.add(ChatColor.BOLD); bannedColours.add(ChatColor.ITALIC); bannedColours.add(ChatColor.MAGIC); bannedColours.add(ChatColor.RESET); bannedColours.add(ChatColor.STRIKETHROUGH); bannedColours.add(ChatColor.UNDERLINE);
			
			// If arg is not empty
			if(!args[1].toString().equals(""))
			{
				// For all ChatColours
				for (ChatColor colour : ChatColor.values())
				{
					// If colour starts with argument
					if(colour.name().toLowerCase().startsWith(args[1].toLowerCase()))
					{
						// If colour is not banned
						if(!bannedColours.contains(ChatColor.valueOf(colour.name().toUpperCase()))) 
						{
							// Adds chatcolour to list
							returnedColourNames.add(Utils.capitalise(colour.name()));
						}
					}
				}
			}
			// If arg is empty
			else
			{
				// For all ChatColours
				for (ChatColor colour : ChatColor.values())
				{
					// If colour is not null
					if(colour.name() != null)
					{
						// If colour is not banned
						if(!bannedColours.contains(ChatColor.valueOf(colour.name().toUpperCase()))) 
						{
							// Adds chatcolour to list
							returnedColourNames.add(Utils.capitalise(colour.name()));
						}
					}
				}
			}
			
			// Sorts list into alphabetical order
			Collections.sort(returnedColourNames);
			
			// Returns list
			return returnedColourNames;
		}
		
		return null;
	}
}
