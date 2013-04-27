package me.zegeorge.main;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.HelpCommand;
import Commands.MessageCommand;
import Commands.PetCommand;
import Listeners.BankEvent;

public class AnticRPG extends JavaPlugin {
	
	Map<String, UUID> pets = new HashMap<String, UUID>();
	
	public void onEnable(){
		
		
		System.out.println("[ANTICRPG] Has been enabled");
		
		
		
		this.getCommand("pet").setExecutor(new PetCommand());
		this.getCommand("help").setExecutor(new HelpCommand());
		this.getCommand("m").setExecutor(new MessageCommand());
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new BankEvent(), this);
		pm.registerEvents(new PetCommand(), this);
		
		
	}
	
	
	public void onDisbale(){
		
		System.out.println("[ANTICRPG] Has been disabled");
		
	}

	
					}


