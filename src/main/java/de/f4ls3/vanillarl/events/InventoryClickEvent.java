package de.f4ls3.vanillarl.events;

import de.f4ls3.vanillarl.VanillaRL;
import de.f4ls3.vanillarl.managers.CraftingManager;
import de.f4ls3.vanillarl.utils.CraftingInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InventoryClickEvent implements Listener
{

    private List<InventoryAction> actions = new ArrayList<>();

    public InventoryClickEvent()
    {
        actions.addAll(Arrays.asList(InventoryAction.PLACE_ALL, InventoryAction.PLACE_ONE, InventoryAction.PLACE_SOME,
                InventoryAction.MOVE_TO_OTHER_INVENTORY, InventoryAction.DROP_ALL_CURSOR, InventoryAction.DROP_ALL_SLOT,
                InventoryAction.DROP_ONE_CURSOR, InventoryAction.DROP_ONE_SLOT, InventoryAction.PICKUP_ALL,
                InventoryAction.PICKUP_HALF, InventoryAction.PICKUP_ONE, InventoryAction.PICKUP_SOME));
    }

    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event)
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if(event.getWhoClicked() instanceof Player)
                {
                    Player player = (Player) event.getWhoClicked();

                    if (CraftingManager.hasInventory(event.getClickedInventory()))
                    {
                        CraftingInventory craftingInventory = CraftingManager.getCraftingInventories().stream().filter(craftingInventory1 -> craftingInventory1.getInventory().equals(event.getClickedInventory())).findFirst().get();

                        if (craftingInventory.getCraftingSlots().contains(event.getSlot()))
                        {
                            craftingInventory.getCraftingGrid().replace(event.getSlot(), craftingInventory.getItem(event.getSlot()));
                            craftingInventory.getCraftingGrid().forEach((integer, itemStack) -> System.out.println("Slot: " + integer + ", Item: " + itemStack.getType().toString()));
                        }
                    }
                }
            }
        }.runTaskLaterAsynchronously(VanillaRL.getInstance(), 2);

        /*if(event.getWhoClicked() instanceof Player)
        {
            Player player = (Player) event.getWhoClicked();

            if (CraftingManager.hasInventory(event.getClickedInventory()))
            {
                CraftingInventory craftingInventory = CraftingManager.getCraftingInventories().stream().filter(craftingInventory1 -> craftingInventory1.getInventory().equals(event.getClickedInventory())).findFirst().get();

                System.out.println("action performd");
                if (craftingInventory.getCraftingSlots().contains(event.getSlot()))
                {
                    if (actions.contains(event.getAction()))
                    {
                        List<ItemStack> grid = new ArrayList<>();
                        craftingInventory.getCraftingSlots().forEach(slot -> grid.add(craftingInventory.getItem(slot)));
                        System.out.println(grid);
                    }

                    if (event.getAction().equals(InventoryAction.PLACE_ALL) || event.getAction().equals(InventoryAction.PLACE_ONE) || event.getAction().equals(InventoryAction.PLACE_SOME))
                    {
                        if (craftingInventory.getItem(event.getSlot()) != null)
                        {

                        }
                    }
                }
            }
        }*/
    }
}
