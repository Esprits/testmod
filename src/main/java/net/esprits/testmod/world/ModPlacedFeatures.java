package net.esprits.testmod.world;

import net.esprits.testmod.TestMod;
import net.esprits.testmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BLOOD_TREE_PLACED_KEY = registerKey("blood_tree_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntreLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BLOOD_TREE_PLACED_KEY, configuredFeatureRegistryEntreLookup.getOrThrow(ModConfiguredFeatures.BLOOD_TREE_KEY),
                VegetationPlacedFeatures.modifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.BLOOD_TREE_SAPLING));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TestMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
