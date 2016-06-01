package events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import uk.co.cherrygoose.cleanerchat.Main;

public class QuitListener implements Listener 
{
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerQuit(PlayerQuitEvent event) 
	{
		// Declares Player
		Player player = event.getPlayer();
				
		// Removes vanilla message
		event.setQuitMessage(null);

    	// For all online players
    	for(Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) 
    	{
    		// Sends online player the kick message
    		onlinePlayer.sendMessage(ChatColor.YELLOW + player.getName() + " disconnected.");
    	}

    	// Logs to console
    	Bukkit.getLogger().info("["+Main.pluginName+"]" + player.getName() + " disconnected.");
	}
}
