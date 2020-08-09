package de.f4ls3.vanillarl.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class ItemBuilder
{
    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private SkullMeta skullMeta;

    public ItemBuilder(Material material)
    {
        itemStack = new ItemStack(material);
    }

    public ItemBuilder(Material material, int amount)
    {
        itemStack = new ItemStack(material, amount);
    }

    public ItemBuilder(Material material, int amount, String displayName)
    {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
    }

    public ItemBuilder(Material material, int amount, String displayName, String... lore)
    {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(Arrays.asList(lore));
    }

    public ItemBuilder(Material material, int amount, String displayName, HashMap<Enchantment, Integer> enchantments, String... lore)
    {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(Arrays.asList(lore));
        enchantments.forEach((enchantment, level) -> itemMeta.addEnchant(enchantment, level, true));
    }

    public ItemBuilder(Material material, int amount, String displayName, HashMap<Enchantment, Integer> enchantments)
    {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        enchantments.forEach(((enchantment, level) -> itemMeta.addEnchant(enchantment, level, true)));
    }

    public ItemBuilder(String skullOwner)
    {
        itemStack = new ItemStack(Material.PLAYER_HEAD, 1);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
    }

    public ItemBuilder(UUID skullOwner)
    {
        itemStack = new ItemStack(Material.PLAYER_HEAD, 1);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
    }

    public ItemBuilder(String skullOwner, int amount)
    {
        itemStack = new ItemStack(Material.PLAYER_HEAD, amount);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
    }

    public ItemBuilder(UUID skullOwner, int amount)
    {
        itemStack = new ItemStack(Material.PLAYER_HEAD, amount);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
    }

    public ItemBuilder(String skullOwner, int amount, HashMap<Enchantment, Integer> enchantments)
    {
        itemStack = new ItemStack(Material.PLAYER_HEAD, amount);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
        enchantments.forEach(((enchantment, level) -> skullMeta.addEnchant(enchantment, level, true)));
    }

    public ItemBuilder(UUID skullOwner, int amount, HashMap<Enchantment, Integer> enchantments)
    {
        itemStack = new ItemStack(Material.PLAYER_HEAD, amount);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
        enchantments.forEach(((enchantment, level) -> skullMeta.addEnchant(enchantment, level, true)));
    }

    public ItemBuilder(String skullOwner, int amount, String displayName, HashMap<Enchantment, Integer> enchantments)
    {
        itemStack = new ItemStack(Material.PLAYER_HEAD, amount);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
        skullMeta.setDisplayName(displayName);
        enchantments.forEach(((enchantment, level) -> skullMeta.addEnchant(enchantment, level, true)));
    }

    public ItemBuilder(UUID skullOwner, int amount, String displayName, HashMap<Enchantment, Integer> enchantments)
    {
        itemStack = new ItemStack(Material.PLAYER_HEAD, amount);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
        skullMeta.setDisplayName(displayName);
        enchantments.forEach(((enchantment, level) -> skullMeta.addEnchant(enchantment, level, true)));
    }

    public ItemStack build()
    {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack buildSkull()
    {
        itemStack.setItemMeta(skullMeta);
        return itemStack;
    }
}
