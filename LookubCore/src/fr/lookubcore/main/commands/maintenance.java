package fr.lookubcore.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.fusesource.jansi.Ansi.Color;

import fr.lookubcore.main.mainClass;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.MinecraftServer;

public class maintenance implements CommandExecutor {
	
	private mainClass main;
	
	public maintenance(mainClass mainClass) {
		this.main = mainClass;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
			if(sender instanceof Player) {
				
				Player player = (Player)sender;

				if(args.length == 0) {
					player.sendMessage(ChatColor.RED + "Commande incorrecte, utilisez: /maintenance <on:off>");
				}

					if(args.length >= 1 && args[0].equalsIgnoreCase("on")) {
					MinecraftServer.getServer().setMotd("§c§lLe serveur est en maintenance !");
					player.sendMessage(ChatColor.GREEN + "Le serveur est maintenant en maintenance !");
					}

					if(args.length == 1 && args[0].equalsIgnoreCase("off")) {
					MinecraftServer.getServer().setMotd(main.getConfig().getString("Motd"));
					player.sendMessage(ChatColor.GREEN + "Le serveur n'est plus en maintenance !");
					}
			}
			
		return false;
	}

}
