package de.f4ls3.vanillarl.utils;

import com.google.gson.internal.$Gson$Preconditions;
import net.minecraft.server.v1_16_R1.NBTBase;
import net.minecraft.server.v1_16_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NBTUtils
{

    public static void setNBTTag(ItemStack item, String key, NBTBase value)
    {
        ItemMeta meta = item.getItemMeta();
        String stored = "";
        if(meta.getDisplayName() != null)
        {
            stored = meta.getDisplayName();
        }

        net.minecraft.server.v1_16_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound comp = nmsItem.getTag();

        comp.set(key, value);
        nmsItem.setTag(comp);

        meta = CraftItemStack.getItemMeta(nmsItem);
        meta.setDisplayName(stored);
        item.setItemMeta(meta);
    }

    public static NBTBase getNBTTag(ItemStack item, String key)
    {
        return CraftItemStack.asNMSCopy(item).getTag().get(key);
    }

    public static boolean hasNBTTag(ItemStack item, String key)
    {
        return CraftItemStack.asNMSCopy(item).getTag().hasKey(key);
    }
}
