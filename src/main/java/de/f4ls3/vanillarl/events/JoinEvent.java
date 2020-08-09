package de.f4ls3.vanillarl.events;

import de.f4ls3.vanillarl.VanillaRL;
import de.f4ls3.vanillarl.managers.EnchantmentManager;
import de.f4ls3.vanillarl.utils.ItemBuilder;
import de.f4ls3.vanillarl.utils.NBTUtils;
import net.minecraft.server.v1_16_R1.NBTTagCompound;
import net.minecraft.server.v1_16_R1.NBTTagString;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinEvent implements Listener
{

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        ItemStack item = new ItemBuilder(Material.TURTLE_HELMET, 1, "§bOxygen Helmet", "§7Water Filtering").build();
        item.addUnsafeEnchantment(EnchantmentManager.WATER_FILTERING, 1);

        player.getInventory().addItem(item);
    }
}
