package uk.co.cherrygoose.cleanerchat;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import commands.ColourCommand;
import events.ChatListener;
import events.JoinListener;
import events.QuitListener;

public class Main extends JavaPlugin 
{
	// Plugin for referencing in use
    private static Plugin plugin;
    public static String pluginName;
    
    @Override
    public void onEnable() 
    {
    	// Assigns plugin to variable
		plugin = this;
		pluginName = plugin.getDescription().getName();  
		    	
		// Creates a config
		plugin.saveDefaultConfig();
	    
		// Registers all event listeners
		Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new QuitListener(), plugin);
		
    	// Logs to console
    	Bukkit.getLogger().info("["+pluginName+"] Enabled");
    }

    @Override
    public void onDisable() 
    {
    	// Logs to console
    	Bukkit.getLogger().info("["+pluginName+"] Disabled");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
    {
    	// If "deathcooldown" command
		if(cmd.getName().equalsIgnoreCase("colour"))
		{
			return ColourCommand.onCommand(sender, cmd, commandLabel, args);
		}
		
    	return false;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
    	// If "deathcooldown" command
		if(cmd.getName().equalsIgnoreCase("colour"))
		{
			return ColourCommand.onTabComplete(sender, cmd, commandLabel, args);
		}
		
		return null;
    }
    
    public static FileConfiguration config()
    {
    	// Returns config
    	return plugin.getConfig();
    }
    public static Plugin plugin()
    {
    	// Returns plugin
    	return plugin;
    }
}
