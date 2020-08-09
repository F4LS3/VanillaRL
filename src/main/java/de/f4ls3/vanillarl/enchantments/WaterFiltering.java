package de.f4ls3.vanillarl.enchantments;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class WaterFiltering extends CustomEnchantment
{

    public WaterFiltering()
    {
        super("water_filtering", "Water Filtering", 1);
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return item.getData().getItemType().equals(Material.TURTLE_HELMET);
    }
}
