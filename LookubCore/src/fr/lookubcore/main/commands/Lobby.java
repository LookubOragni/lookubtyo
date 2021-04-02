package fr.lookubcore.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lookubcore.main.mainClass;
import net.md_5.bungee.api.ChatColor;

public class Lobby implements CommandExecutor {
	
	private mainClass main; 

	public Lobby(mainClass mainClass) {
		this.main = mainClass;	
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
		
			if(cmd.getName().equalsIgnoreCase("lobby")) {
				
				Player player = (Player)sender;
				
				World playerworld = player.getWorld();
				
				String playerworldstring = playerworld.getName().toString();
				
				Location loca = player.getLocation().getBlock().getLocation();
				
				double locax = loca.getX();
				double locay = loca.getY();
				double locaz = loca.getZ();
				
				
				if(args.length == 0) {
					Location lobbyloc = new Location(Bukkit.getWorld(main.getConfig().getString("world")), main.getConfig().getDouble("location_x"), main.getConfig().getDouble("location_y"), main.getConfig().getDouble("location_z"));
					
					player.teleport(lobbyloc);
				}
				
				if(args.length == 1 && args[0].equalsIgnoreCase("set")) {
					
					player.sendMessage(ChatColor.GREEN + "Le lobby à bien été set en " + "x: " + locax + " y: " + locay + " z: " + locaz + " dand le monde: " + playerworldstring);
					
					main.getConfig().set("world", playerworldstring);
					main.getConfig().set("location_x", locax);
					main.getConfig().set("location_y", locay);
					main.getConfig().set("location_z", locaz);
					
					main.saveConfig();
				}
				
				if(args.length == 1 && args[0].equalsIgnoreCase("info")) {
					
					player.sendMessage(ChatColor.GREEN + "Le lobby se trouve en " + ChatColor.YELLOW + "x: " + locax + " y: " + locay + " z: " + locaz + ChatColor.GREEN + " dans le monde: " + ChatColor.YELLOW + playerworldstring);
					
				}
				
				return true;
			}
			
		}
		
		return false;
	}

}
