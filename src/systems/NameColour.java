package systems;

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
		Main.config().set("PlayerData." + player.getUniqueId() + ".NameColour", colour.name());
	}
	
	public static ChatColor get(Player player)
	{
		// If nameColour is not null
		if (Main.config().getString("PlayerData." + player.getUniqueId() + ".NameColour") != null)
		{
			// Return name colour of Player
			return ChatColor.valueOf(Main.config().getString("PlayerData." + player.getUniqueId() + ".NameColour"));
		}
		
		// Else return reset colour
		return ChatColor.RESET;
	}
}
