package mainPackage.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import Tasks.timerTask;
import mainPackage.mainClass;
import net.md_5.bungee.api.ChatColor;

public class CreeperSpawn implements CommandExecutor {
	
	private mainClass main;
	timerTask takstime = new timerTask();

	public CreeperSpawn(mainClass mainClass) {
		this.main = mainClass;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				
			if(cmd.getName().equalsIgnoreCase("creeper")) {
				
				Player player = Bukkit.getPlayer(sender.getName().toString());				
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				Location playerloca = player.getLocation().getBlock().getLocation();
				
				player.getWorld().spawnEntity(playerloca, EntityType.CREEPER);
				System.out.println("Un creeper a spawn (c'est le joueur " + player + " qui a éxécuter cette commande)");
				player.sendMessage(ChatColor.AQUA + "Tu viens de faire spawner un creeper !");
				
				return true;
			}
		
		return false;
	}

}

