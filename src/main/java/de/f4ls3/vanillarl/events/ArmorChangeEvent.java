package de.f4ls3.vanillarl.events;

import de.f4ls3.vanillarl.managers.EnchantmentManager;
import de.f4ls3.vanillarl.armorapi.ArmorEquipEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmorChangeEvent implements Listener
{

    @EventHandler
    public void onArmorChange(ArmorEquipEvent event)
    {
        if(event.getNewArmorPiece() != null)
        {
            if (event.getNewArmorPiece().getType().equals(Material.TURTLE_HELMET))
            {
                if (event.getNewArmorPiece().getItemMeta().hasEnchant(EnchantmentManager.WATER_FILTERING))
                {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0, true, false, false));
                }
            }
        }

        if (event.getOldArmorPiece() != null)
        {
            if (event.getOldArmorPiece().getType().equals(Material.TURTLE_HELMET))
            {
                if (event.getOldArmorPiece().getItemMeta().hasEnchant(EnchantmentManager.WATER_FILTERING))
                {
                    event.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
                }
            }
        }
    }
}
