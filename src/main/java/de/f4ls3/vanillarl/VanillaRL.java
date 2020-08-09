package de.f4ls3.vanillarl;

import de.f4ls3.vanillarl.armorapi.ArmorListener;
import de.f4ls3.vanillarl.events.*;
import de.f4ls3.vanillarl.managers.EnchantmentManager;
import de.f4ls3.vanillarl.managers.RecipeManager;
import de.f4ls3.vanillarl.armorapi.DispenserArmorListener;
import de.f4ls3.vanillarl.utils.Var;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class VanillaRL extends JavaPlugin
{

    private static VanillaRL instance;

    private static RecipeManager recipeManager;
    private static EnchantmentManager enchantmentManager;

    @Override
    public void onEnable()
    {
        Bukkit.getConsoleSender().sendMessage(Var.PREFIX + "§7Enabling VanillaRL...");
        instance = this;
        recipeManager = new RecipeManager();
        enchantmentManager = new EnchantmentManager();

        recipeManager.registerRecipes();
        enchantmentManager.registerEnchantments();

        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
        Bukkit.getPluginManager().registerEvents(new DispenserArmorListener(), this);
        Bukkit.getPluginManager().registerEvents(new ArmorChangeEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlockEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickEvent(), this);

        Bukkit.getConsoleSender().sendMessage(Var.PREFIX + "§7Enabled VanillaRL");
    }

    @Override
    public void onDisable()
    {
        instance = null;
    }

    public static VanillaRL getInstance() {
        return instance;
    }
}
