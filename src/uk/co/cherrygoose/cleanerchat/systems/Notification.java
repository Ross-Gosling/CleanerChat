package uk.co.cherrygoose.cleanerchat.systems;

import org.bukkit.entity.Player;

import uk.co.cherrygoose.cleanerchat.Main;

public class Notification 
{
	public static void toggleNotify(Player player) 
	{
		// Gets the current notifciation mode of the player
		boolean notifications = getNotify(player);
		
		
		if(notifications)
			setNotify(player, false);
		else
			setNotify(player, true);
	}

	private static void setNotify(Player player, boolean mode) 
	{
		// Sets DisplayMode in playerdata to the mode in string form
		Main.playerdata().set(player.getUniqueId() + ".ChatNotifications", mode);
	}
	
	public static boolean getNotify(Player player) 
	{
		// If a DisplayMode is stored
		try
		{
			// Return DisplayMode stored in player data
			return Main.playerdata().getBoolean(player.getUniqueId() + ".ChatNotifications");
		}
		catch(NullPointerException e)
		{
			// Return default value
			return false;
		}
	}
}
