package uk.co.cherrygoose.cleanerchat.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import uk.co.cherrygoose.cleanerchat.systems.NameColour;

public class JoinListener implements Listener 
{
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent event) 
	{
		// Gets Player
		Player player = event.getPlayer();

		// Sets the tab-menu name of the player with colouring
		player.setPlayerListName(NameColour.get(player) + player.getName());	
		
		// Removes vanilla message
		event.setJoinMessage(null);
				
    	// For all online players
    	for(Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) 
    	{
    		// Sends online player the join message
    		onlinePlayer.sendMessage(ChatColor.YELLOW + player.getName() + " connected.");
    	}
	}	
}
