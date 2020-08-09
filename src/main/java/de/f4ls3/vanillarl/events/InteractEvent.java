package de.f4ls3.vanillarl.events;

import de.f4ls3.vanillarl.managers.CraftingManager;
import de.f4ls3.vanillarl.utils.CraftingInventory;
import de.f4ls3.vanillarl.utils.Var;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class InteractEvent implements Listener
{

    private Inventory inv;
    private CraftingInventory craftingInventory;

    public InteractEvent()
    {
        inv = Bukkit.createInventory(null, 3 * 9, "§eTable");
        craftingInventory = new CraftingInventory(inv, Arrays.asList(0, 1, 2, 9, 10, 11, 18, 19, 20), 16);
        CraftingManager.addCraftingInventory(craftingInventory);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
        {
            Block block = event.getClickedBlock();

            if(block.hasMetadata("vanillaRL-ID"))
            {
                event.setCancelled(true);
                int vanillaRLID = block.getMetadata("vanillaRL-ID").get(0).asInt();

                if(vanillaRLID == 0)
                {
                    event.getPlayer().openInventory(craftingInventory.getInventory());
                }
            }

            if(block.getType().equals(Material.ENCHANTING_TABLE))
            {
                event.setCancelled(true);
                event.getPlayer().sendMessage(Var.PREFIX + "It seems like that didn't work. You have to find another way to enchant!");
            }
        }
    }
}
