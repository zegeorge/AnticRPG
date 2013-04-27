package Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label,
			String[] args) {
		if(!(cs instanceof Player)){
			cs.sendMessage("[ANTICRPG]Only players can use this command");
			
		}else {
			cs.sendMessage("Check your Caracter"+ChatColor.RED+ "journal" + " for a list of commands");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return false;
	}

}
