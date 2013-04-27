package Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor{
	


	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label,
			String[] args) {
		Player player = (Player) cs;
		if (args.length == 0){
			player.sendMessage(ChatColor.DARK_RED + "Not enough arguments");
			}
			if (args.length == 1){
			player.sendMessage(ChatColor.DARK_RED + "Not enough arguments");
			}
			if (args.length == 2){
			Player targetMessagePlayer = player.getServer().getPlayer(args[0]);
			cs.sendMessage(ChatColor.GOLD+"You sent a message");
			targetMessagePlayer.sendMessage(ChatColor.RED+cs.getName()+ChatColor.BLUE+" sent you a message " + ChatColor.BLACK+": " +ChatColor.RESET+ChatColor.GOLD+args[1]);
			
			
			
		return false;
	



			}
			return false;
		}
}