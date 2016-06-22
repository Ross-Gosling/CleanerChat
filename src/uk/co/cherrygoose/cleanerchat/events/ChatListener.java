package uk.co.cherrygoose.cleanerchat.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import uk.co.cherrygoose.cleanerchat.Main;
import uk.co.cherrygoose.cleanerchat.systems.NameColour;
import uk.co.cherrygoose.cleanerchat.systems.Notification;

public class ChatListener implements Listener 
{
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerChatEvent(AsyncPlayerChatEvent event) 
	{
		// Cancels sending the message to anyone
		event.setCancelled(true);
		
        // Gets message sender
        Player player = event.getPlayer();
		// Gets raw message
        String rawMessage = event.getMessage();
        // Declares empty string for formatted message
        String message = "";
                
        // Declares message style formatting
        ChatColor playerColour = NameColour.get(player);
        ChatColor msgColour = ChatColor.WHITE;
        String sConnector = ": ";
        
        // Creates formatted message
        message = playerColour + player.getDisplayName() + msgColour + sConnector + rawMessage;
        
        // For all recipients
    	for(Player recipient : event.getRecipients()) 
    	{
    		// Sends recipient the message
    		recipient.sendMessage(message);
    		
    		// If recipient has notifications and is not the sender
    		if((Notification.getNotify(recipient)) && (recipient != player))
    		{
				// Sends player audible feedback
    			recipient.playSound(recipient.getLocation(), Sound.BLOCK_NOTE_PLING, 1.0f, 1.0f);
    		}
    	}
    	
    	// Logs to console
    	Bukkit.getLogger().info("["+Main.pluginName+"]" + player.getDisplayName() + sConnector + rawMessage);
	}
}
