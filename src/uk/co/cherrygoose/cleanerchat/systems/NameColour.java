package uk.co.cherrygoose.cleanerchat.systems;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import uk.co.cherrygoose.cleanerchat.Main;

public class NameColour 
{
	public static void set(Player player, ChatColor colour)
	{
		// Sets the tab-menu name of the player with colouring
		player.setPlayerListName(colour + player.getName());
		
		// Sets name colour of Player in config
		Main.playerdata().set(player.getUniqueId() + ".NameColour", colour.name());
	}
	
	public static ChatColor get(Player player)
	{
		// If nameColour exists
		try
		{
			// Return name colour of Player
			return ChatColor.valueOf(Main.playerdata().getString(player.getUniqueId() + ".NameColour"));
		}
		catch(NullPointerException e)
		{
			return  ChatColor.WHITE;
		}
	}
}
