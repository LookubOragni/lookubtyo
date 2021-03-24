package mainPackage.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.avaje.ebeaninternal.server.lib.sql.Prefix;
import com.earth2me.essentials.chat.EssentialsChat;
import com.mojang.authlib.yggdrasil.response.User;

import me.TSMR.Currency.Balance;
import me.lucko.luckperms.api.Group;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		// TODO Auto-generated method stub
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			Balance bal = Balance.getInstance();
			boolean permcheck = perms.has(player, "lookub.upgrade.grade.verif.use");
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			String upgradepltoch = "lp user " + player.getName().toString() + " parent set chevalier";
			
					if(cmd.getName().equalsIgnoreCase("alert")) {		
						
							if(args.length == 0) {
								player.sendMessage(ChatColor.RED + "The correct command is /alert {Message}");
							}
							
							if(args.length > 1) {
								player.sendMessage(ChatColor.BOLD.AQUA + "The alert was sucessful send for all players");
								
								StringBuilder bc = new StringBuilder();
								for(String part : args) {
									bc.append(part + " ");
								}
								
								Bukkit.broadcastMessage("The player " + ChatColor.BOLD.AQUA + player.getName() + ChatColor.WHITE + " was use the alert command and it's his/her message is " + ChatColor.AQUA + "'" + bc.toString() + "'");	
							} else {
								if(args.length == 1) {

									StringBuilder bc = new StringBuilder();
									for(String part : args) {
										bc.append(part + "");
								}
									
									player.sendMessage(ChatColor.BOLD.AQUA + "The alert was sucessful send for all players");
									Bukkit.broadcastMessage("The player " + ChatColor.BOLD.AQUA + player.getName() + ChatColor.WHITE + " was use the alert command and it's his/her message is " + ChatColor.AQUA + "'" + bc.toString() + "'");
								}
									
									StringBuilder bc = new StringBuilder();
									for(String part : args) {
										bc.append(part + " ");
								}
							}
							
							
							return true;
					}
									
					
					// In upper = /alert <Message> 
				
					if(cmd.getName().equalsIgnoreCase("money")) {
						player.sendMessage(ChatColor.AQUA + "Your current balance is " + bal.get(player) + "$");
					}
			
					// In upper = /money
					
					if(cmd.getName().equalsIgnoreCase("upgrade")) {
						if(args.length == 0) {
							player.sendMessage(ChatColor.RED + "The correct command is: /upgrade {Thing you want upgrade}");
						}
						
						if(args.length >= 1) {
							StringBuilder bc02 = new StringBuilder();
							for(String part02 : args) {
								bc02.append(part02 + " ");
							}
							if(bc02.toString().contains("grade")) {
								if(bal.get(player) >= 15000) {
									if(permcheck == true);{
										 Bukkit.dispatchCommand(console, upgradepltoch);
										 bal.set(player, -15000);
										}
									}
								} else {
									player.sendMessage(ChatColor.RED + "This argument no match with the others valids arguments");
								}
							}
						}
								return true;
							}					
		
		
		return false;
	}
	}
	

