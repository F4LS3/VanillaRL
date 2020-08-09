package de.f4ls3.vanillarl.managers;

import de.f4ls3.vanillarl.utils.CraftingInventory;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CraftingManager
{

    private static List<CraftingInventory> craftingInventories = new ArrayList<>();

    public static void addCraftingInventory(CraftingInventory craftingInventory)
    {
        craftingInventories.add(craftingInventory);
    }

    public static boolean hasCraftingInventory(CraftingInventory craftingInventory)
    {
        return craftingInventories.contains(craftingInventory);
    }

    public static boolean hasInventory(Inventory inventory)
    {
        return craftingInventories.stream().filter(craftingInventory -> craftingInventory.getInventory().equals(inventory)).count() > 0;
    }

    public static List<CraftingInventory> getCraftingInventories() {
        return craftingInventories;
    }
}
