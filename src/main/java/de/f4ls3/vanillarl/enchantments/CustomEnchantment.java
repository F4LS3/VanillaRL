package de.f4ls3.vanillarl.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class CustomEnchantment extends Enchantment
{

    protected String name;
    protected int maxLevel;

    public CustomEnchantment(String namespace, String name, int maxLevel)
    {
        super(NamespacedKey.minecraft(namespace));
        this.name = name;
        this.maxLevel = maxLevel;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getMaxLevel()
    {
        return maxLevel;
    }

    @Override
    public int getStartLevel()
    {
        return 0;
    }

    @Override
    public EnchantmentTarget getItemTarget()
    {
        return null;
    }

    @Override
    public boolean isTreasure()
    {
        return false;
    }

    @Override
    public boolean isCursed()
    {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other)
    {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item)
    {
        return false;
    }
}
