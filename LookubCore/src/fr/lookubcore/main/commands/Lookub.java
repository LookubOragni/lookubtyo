package fr.lookubcore.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lookubcore.main.mainClass;
import net.md_5.bungee.api.ChatColor;

public class Lookub implements CommandExecutor {
	
	private mainClass main; 
	
	public Lookub(mainClass mainClass) {
		this.main = mainClass;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("lookub")) {
				if(args.length == 0) {
					player.sendMessage(ChatColor.RED + "Vous devez utiliser la commande comme ça: /lookub <reload>");
				}
				
				if(args.length >= 1 && args[0].equalsIgnoreCase("reload")) {
					main.reloadConfig();
					main.saveConfig();
					player.sendMessage(ChatColor.GREEN + "[LookubCore] Le plugin à été reload");
				}
				
				if(args.length >= 1 && !args[0].equalsIgnoreCase("reload") && !args[0].equalsIgnoreCase("rl")) {
					player.sendMessage(ChatColor.RED + "Argument incorrect");
				}
				
				if(args.length >= 1 && args[0].equalsIgnoreCase("rl")) {
					main.reloadConfig();
					main.saveConfig();
					player.sendMessage(ChatColor.GREEN + "[LookubCore] Le plugin à été reload");
				}
			}
		}
		
		return false;
	}

}
