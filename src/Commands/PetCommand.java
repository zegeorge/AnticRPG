package Commands;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PetCommand implements CommandExecutor, Listener{
	
	
	Map<String, UUID> pet = new HashMap<String, UUID>();
	

	
	



	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		   if(!(sender instanceof Player)){
	            sender.sendMessage("THIS COMMAND CAN ONLY BE USED BY PLYAERS");
	        }else {
	            Player player = (Player) sender;
	            if(args.length == 0){
	                sender.sendMessage(ChatColor.RED+"PETS : WOLF,ZOMBIE");
	             
	            }if(args.length == 2){
	                sender.sendMessage(ChatColor.GOLD+"You have spawned  a pet");

	                spawnPet(player, args[0], args[1]);
	            }
	        }
		return true;
	             
		}

	private void spawnPet(Player player, String type, String name) {
		EntityType monster = EntityType.fromName(type.toUpperCase());
		if(monster == EntityType.WOLF){
			Wolf mob = (Wolf) Bukkit.getWorld(player.getWorld().getName()).spawnEntity(player.getLocation(), monster);
			mob.setAngry(false);
			mob.setSitting(true);
			mob.setOwner(player);
			mob.setTarget(player);
			mob.setAgeLock(true);
			mob.setCustomName(ChatColor.RED+name);
			
			mob.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 7200, 1));
			
			
		}else if(monster == EntityType.ZOMBIE){
			Zombie mob = (Zombie) Bukkit.getWorld(player.getWorld().getName()).spawnEntity(player.getLocation(), monster);
			mob.setTarget(player);
			mob.setBaby(true);
			mob.setNoDamageTicks(20);
			pet.put(player.getName(), mob.getUniqueId());
			
			mob.setCustomName(ChatColor.RED+name);
		}
		}
	// THIS DOESN'T WORK MUST GET IT DONE 
		@EventHandler
		public void onEntityTargetLiving(EntityTargetLivingEntityEvent e){
			Bukkit.broadcastMessage("test");
			if(e.getTarget() instanceof Player){
			Bukkit.broadcastMessage("instanceof");
			
			Player player = (Player) e.getTarget();
			
			if(pet.containsKey(player.getName())) { 
				Bukkit.broadcastMessage("petid");
			    UUID petId = pet.get(player.getName());
				if(e.getEntity().getUniqueId().equals(petId)) {
					Bukkit.broadcastMessage("getENTITY");
			    	e.setCancelled(true);
			    	
			    	
			    }
		
				
			}
	
	}

		}
		

}

