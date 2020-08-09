package de.f4ls3.vanillarl.armorapi;

import de.f4ls3.vanillarl.armorapi.ArmorEquipEvent;
import de.f4ls3.vanillarl.armorapi.ArmorType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseArmorEvent;

/**
 * @author Arnah
 * @since Feb 08, 2019
 */
public class DispenserArmorListener implements Listener{
	
	
	@EventHandler
	public void dispenseArmorEvent(BlockDispenseArmorEvent event){
		ArmorType type = ArmorType.matchType(event.getItem());
		if(type != null){
			if(event.getTargetEntity() instanceof Player){
				Player p = (Player) event.getTargetEntity();
				ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(p, ArmorEquipEvent.EquipMethod.DISPENSER, type, null, event.getItem());
				Bukkit.getServer().getPluginManager().callEvent(armorEquipEvent);
				if(armorEquipEvent.isCancelled()){
					event.setCancelled(true);
				}
			}
		}
	}
}