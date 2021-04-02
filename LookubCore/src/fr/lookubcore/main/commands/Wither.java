package fr.lookubcore.main.commands;

import java.lang.System.Logger;
import java.util.HashMap;
import java.util.Random;
import java.util.TimerTask;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import fr.lookubcore.main.mainClass;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class Wither implements CommandExecutor {
	
	private boolean canexe = true;
	
	private mainClass main;
	
	public Wither(mainClass mainClass) {
		this.main = mainClass;	
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player)sender;
			String playername = player.getName();
			Economy eco = mainClass.getEconomy();
			Location loca = player.getLocation().getBlock().getLocation();
			double wiwiprix = main.getConfig().getDouble("prix");
			int reg = 100;
			Random r = new Random();
			double x = r.nextInt(reg);
			double y = r.nextInt(reg);
			double z = r.nextInt(reg);
			int timecool = main.getConfig().getInt("timecooldown");
			Location spawnChest = new Location(Bukkit.getWorld("world"), x, y, z);
			
		if(cmd.getName().equalsIgnoreCase("wither")) {
			
			if(canexe == true) {
				
				canexe = false;
				
				 main.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable()
		        {
		            public void run()
		            {
		                canexe = true;
		                
		                //La ligne en haut s'execute quand le timer arrive à la fin
		            }
		        }, timecool * 20);
			
				if(eco.getBalance(player) >= wiwiprix) {
				eco.withdrawPlayer(player, wiwiprix);
				player.getWorld().spawnEntity(loca, EntityType.WITHER);
				player.sendMessage(ChatColor.GREEN + "Vous avez été débité de " + wiwiprix);
				player.sendMessage(ChatColor.AQUA + "Le Wither à bien spawn !");
				
			} else {
				player.sendMessage(ChatColor.RED + "Vous ne pouvez pas acheter de wither car il vous manque " + (wiwiprix - eco.getBalance(player)) );
				player.playSound(loca, Sound.ENDERMAN_HIT, 40, 0);
			}
		
			return true;
			
			} else {		
				player.sendMessage(ChatColor.RED + "Cette commande ne peut être utilisée tout les " + timecool + " secondes");
			}
			

		}
		
		}
		

		return false;
	}
	}


