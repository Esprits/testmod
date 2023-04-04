package net.esprits.testmod.data;

import net.esprits.testmod.block.ModBlocks;
import net.esprits.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLOOD_BLOCK);

        blockStateModelGenerator.registerLog(ModBlocks.BLOOD_TREE_LOG).log(ModBlocks.BLOOD_TREE_LOG).wood(ModBlocks.BLOOD_TREE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_BLOOD_TREE_LOG).log(ModBlocks.STRIPPED_BLOOD_TREE_LOG).wood(ModBlocks.STRIPPED_BLOOD_TREE_WOOD);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLOOD_TREE_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLOOD_TREE_LEAVES);

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.BLOOD_TREE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PHILOSOPHERS_STONE, Models.GENERATED);
    }
}
