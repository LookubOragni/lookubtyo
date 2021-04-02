package fr.lookubcore.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Broadcast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("broadcast")) {
			
			StringBuilder bc = new StringBuilder();
			
			for(String part : args) {
				bc.append(part + " ");
			}
						
			if(args.length == 0) {
				player.sendMessage(ChatColor.RED + "La commande est invalide : faites /broadcast <message>");
			}
			
			if(args.length >= 1) {
				Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "Annonce" + ChatColor.YELLOW + "]" + " " + ChatColor.GREEN + bc.toString());

			}
			
			return true;
		}
		
		// En haut la commande /bc ou /broadcast
		
		return false;
	}

}
