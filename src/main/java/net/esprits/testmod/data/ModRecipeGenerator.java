package net.esprits.testmod.data;

import net.esprits.testmod.block.ModBlocks;
import net.esprits.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.BLOOD, RecipeCategory.MISC, ModBlocks.BLOOD_BLOCK);

        offerShapelessRecipe(exporter, ModBlocks.BLOOD_TREE_PLANKS, ModBlocks.BLOOD_TREE_LOG, RecipeCategory.BUILDING_BLOCKS.toString(), 4);
        offerShapelessRecipe(exporter, ModBlocks.BLOOD_TREE_PLANKS, ModBlocks.BLOOD_TREE_WOOD, RecipeCategory.BUILDING_BLOCKS.toString(), 4);
        offerShapelessRecipe(exporter, ModBlocks.BLOOD_TREE_PLANKS, ModBlocks.STRIPPED_BLOOD_TREE_LOG, RecipeCategory.BUILDING_BLOCKS.toString(), 4);
        offerShapelessRecipe(exporter, ModBlocks.BLOOD_TREE_PLANKS, ModBlocks.STRIPPED_BLOOD_TREE_WOOD, RecipeCategory.BUILDING_BLOCKS.toString(), 4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PHILOSOPHERS_STONE)
                .pattern(" B ")
                .pattern(" # ")
                .pattern(" B ")
                .input('B', ModItems.BLOOD)
                .input('#', ModBlocks.BLOOD_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BLOOD),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BLOOD))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLOOD_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLOOD_BLOCK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.PHILOSOPHERS_STONE)));
    }
}