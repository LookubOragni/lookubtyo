package mainPackage;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import mainPackage.commands.Commands;
import mainPackage.commands.CreeperSpawn;
public class mainClass extends JavaPlugin {

	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		super.onEnable();	
		System.out.println("The plugin was launch sucessful");
		getCommand("alert").setExecutor(new Commands());	
		getCommand("money").setExecutor(new Commands());
		getCommand("upgrade").setExecutor(new Commands());
		getCommand("creeper").setExecutor(new CreeperSpawn(this));
	
			String[] messages = {"Noubliez pas de nous suivre sur le Twitter du serveur https://twitter.com/lookubserver", "Rejoignez notre discord https://discord.gg/v4FepDCTGa"};
			Bukkit.getScheduler().runTaskTimer(this, new BukkitRunnable() {
				
				@Override
				public void run() {
					Bukkit.broadcastMessage(messages[new Random().nextInt(messages.length)]);
					
				}
			}, 0, 20 * 120);
			
			// In upper is the occasional time pub message
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
		System.out.println("The plugin was shutdown sucessful, bye !");
	}

}
