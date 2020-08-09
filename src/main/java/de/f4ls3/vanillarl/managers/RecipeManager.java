package de.f4ls3.vanillarl.managers;

import de.f4ls3.vanillarl.utils.ItemBuilder;
import de.f4ls3.vanillarl.utils.NBTUtils;
import net.minecraft.server.v1_16_R1.NBTTagInt;
import net.minecraft.server.v1_16_R1.NBTTagString;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_16_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager
{

    public void registerRecipes()
    {
        ItemStack skullStack = new ItemBuilder(Material.PLAYER_HEAD, 1, "§eTABLE").build();
        Bukkit.getUnsafe().modifyItemStack(skullStack, "{display:{Name:\"{\\\"text\\\":\\\"§eTable\\\"}\"},SkullOwner:{Id:[I;-155761099,305614759,-1725258085,-1320800752],Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTQ1YzcwZTVlNWE5NmJhZTQ1YzY1MzBjYTgzZmFmNTMyMzE2NDJjY2EwNmRmZjU2Nzc2NDBlZGU5NzhjZTNiMiJ9fX0=\"}]}}}");

        NBTUtils.setNBTTag(skullStack, "vanillaRL-ID", NBTTagInt.a(0));
        NBTUtils.setNBTTag(skullStack, "vanillaRL-Name", NBTTagString.a("§eTable"));

        ShapedRecipe table = new ShapedRecipe(NamespacedKey.minecraft("table"), skullStack);
        table.shape("WLW", "WRW", "WWW");
        table.setIngredient('W', Material.OAK_PLANKS);
        table.setIngredient('L', Material.LEATHER);
        table.setIngredient('R', Material.REDSTONE_BLOCK);

        Bukkit.addRecipe(table);
        Bukkit.removeRecipe(NamespacedKey.minecraft("anvil"));
    }
}
