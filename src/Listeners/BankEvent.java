package Listeners;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class BankEvent implements Listener{
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		Player player = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			
		
		Block block = e.getClickedBlock();
		if(block.getType() == Material.ENDER_CHEST){
			player.sendMessage(ChatColor.GOLD+"Bank Opend.");
			e.setCancelled(true);
			Inventory binv = Bukkit.createInventory(player, 9, ChatColor.RED+player.getName()+ChatColor.GOLD+"'s Bank");
			player.openInventory(binv);
			
			
		}
	}

	}
}
