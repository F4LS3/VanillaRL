package de.f4ls3.vanillarl.managers;

import de.f4ls3.vanillarl.enchantments.WaterFiltering;
import de.f4ls3.vanillarl.utils.Var;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EnchantmentManager
{
    public static final Enchantment WATER_FILTERING = new WaterFiltering();

    private ArrayList<Enchantment> enchantments = new ArrayList<>();

    public void registerEnchantments()
    {
        enchantments.add(WATER_FILTERING);

        for (Enchantment enchantment : enchantments) {
            if(!Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(enchantment)) {
                registerEnchantment(enchantment);
            }
        }
    }

    private void registerEnchantment(Enchantment enchantment)
    {
        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);
            Enchantment.registerEnchantment(enchantment);
            Bukkit.getConsoleSender().sendMessage(Var.PREFIX + "§7Registered enchantment §4" + enchantment.getKey());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
