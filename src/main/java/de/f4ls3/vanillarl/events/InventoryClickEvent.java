package de.f4ls3.vanillarl.events;

import de.f4ls3.vanillarl.managers.CraftingManager;
import de.f4ls3.vanillarl.utils.CraftingInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Recipe;

import java.util.Arrays;
import java.util.List;

public class InventoryClickEvent implements Listener
{

    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event)
    {
        if(event.getWhoClicked() instanceof Player)
        {
            Player player = (Player) event.getWhoClicked();

            if (CraftingManager.hasInventory(event.getClickedInventory()))
            {
                CraftingInventory craftingInventory = CraftingManager.getCraftingInventories().stream().filter(craftingInventory1 -> craftingInventory1.getInventory().equals(event.getClickedInventory())).findFirst().get();
                System.out.println(Arrays.toString(craftingInventory.getInventory().getContents()));

                if (craftingInventory.getCraftingSlots().contains(event.getSlot()))
                {
                    if (event.getAction().equals(InventoryAction.PLACE_ALL) || event.getAction().equals(InventoryAction.PLACE_ONE) || event.getAction().equals(InventoryAction.PLACE_SOME))
                    {
                        System.out.println(Bukkit.getRecipesFor(craftingInventory.getItem(event.getSlot())));
                    }
                }
            }
        }
    }
}
