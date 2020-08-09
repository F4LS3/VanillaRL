package de.f4ls3.vanillarl.events;

import de.f4ls3.vanillarl.VanillaRL;
import net.minecraft.server.v1_16_R1.ItemStack;
import net.minecraft.server.v1_16_R1.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R1.inventory.CraftItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class BlockEvent implements Listener
{

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
        Block block = event.getBlock();
        ItemStack nmsItem = CraftItemStack.asNMSCopy(event.getItemInHand());
        NBTTagCompound comp = nmsItem.getTag();

        if(comp != null && comp.hasKey("vanillaRL-ID"))
        {
            block.setMetadata("vanillaRL-ID", new FixedMetadataValue(VanillaRL.getInstance(), comp.getInt("vanillaRL-ID")));
            if(comp.hasKey("vanillaRL-Name"))
            {
                block.setMetadata("vanillaRL-Name", new FixedMetadataValue(VanillaRL.getInstance(), comp.getString("vanillaRL-Name")));
            }
        }

        /*if(event.getItemInHand().getType().equals(Material.PLAYER_HEAD) && event.getItemInHand().getItemMeta().getDisplayName().equals("§e§lTABLE"))
        {
            block.setMetadata("vanillaRL-ID", new FixedMetadataValue(VanillaRL.getInstance(), 0));
            block.setMetadata("vanillaRL-Name", new FixedMetadataValue(VanillaRL.getInstance(), "§e§lTABLE"));
        }*/
    }
}
