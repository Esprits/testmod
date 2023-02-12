package net.esprits.testmod.item;

import net.esprits.testmod.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ALCHEMY = FabricItemGroup.builder(
            new Identifier(TestMod.MOD_ID, "alchemy"))
            .icon(() -> new ItemStack(ModItems.LAPIS_PHILOSOPHORUM))
            .build();
}