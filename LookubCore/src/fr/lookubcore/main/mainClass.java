package fr.lookubcore.main;

import java.io.File;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import fr.lookubcore.main.commands.Broadcast;
import fr.lookubcore.main.commands.Wither;
import fr.lookubcore.main.commands.maintenance;
import io.netty.util.internal.chmv8.ConcurrentHashMapV8.Action;
import fr.lookubcore.main.commands.Lobby;
import fr.lookubcore.main.commands.Lookub;
import fr.lookubcore.main.commands.Ping;
import net.milkbowl.vault.economy.Economy;

public class mainClass extends JavaPlugin {
	
    public static Economy econ = null;
    public static Economy getEconomy() {
    	return econ;
    }
    

	@Override
	public void onEnable() {
		
	
		if(!new File(getDataFolder(), "config.yml").exists()){
            saveDefaultConfig();
            reloadConfig();
        }

		System.out.println("[LookubCore] LookubCore viens de demarre !");
		
		getCommand("wither").setExecutor(new Wither(this));
		getCommand("broadcast").setExecutor(new Wither(null));
		getCommand("lookub").setExecutor(new Lookub(this));
		getCommand("ping").setExecutor(new Ping());
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("lobby").setExecutor(new Lobby(this));
		getCommand("maintenance").setExecutor(new maintenance(this));
		
		super.onEnable();
				
				if (!setupEconomy() ) {
		            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
		            getServer().getPluginManager().disablePlugin(this);
		            return;
		        }
			}

	public boolean setupEconomy() {
	    if (getServer().getPluginManager().getPlugin("Vault") == null) {
	        return false;
	    }
	    RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
	    if (rsp == null) {
	        return false;
	    }
	    econ = rsp.getProvider();
	    return econ != null;
	}
}


