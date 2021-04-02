package fr.lookubcore.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Ping implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player)sender;
		int ping = ((CraftPlayer)player).getHandle().ping;
		
		if(ping <= 70) {
			
			player.sendMessage(ChatColor.GREEN + "Votre ping est de " + ping);
			
			return true;
		}
		
		if(ping >= 70) {
			
			player.sendMessage(ChatColor.GREEN + "Votre ping est de " + ChatColor.YELLOW + ping);
			
			return true;
		}
		
		return false;
	}

}
