package de.f4ls3.vanillarl.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class CustomShapedRecipe
{

    private HashMap<Integer, Material> ingredients;
    private ItemStack result;

    public CustomShapedRecipe(ItemStack result)
    {
        this.ingredients = new HashMap<>();
        this.result = result;
    }

    public CustomShapedRecipe(HashMap<Integer, Material> ingredients, ItemStack result)
    {
        this.ingredients = ingredients;
        this.result = result;
    }

    public void addIngredient(int slot, Material material)
    {
        ingredients.put(slot, material);
    }

    public HashMap<Integer, Material> getIngredients()
    {
        return ingredients;
    }
}
