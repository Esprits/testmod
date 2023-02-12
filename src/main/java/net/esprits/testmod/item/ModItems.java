package net.esprits.testmod.item;

import net.esprits.testmod.TestMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PHILOSOPHERS_STONE = registerItem("philosophers_stone",
            new Item(new FabricItemSettings()));
    public static final Item BLOOD = registerItem("blood",
            new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.TOOLS, PHILOSOPHERS_STONE); // To add to vanilla groups
        addToItemGroup(ModItemGroup.ALCHEMY, PHILOSOPHERS_STONE); // To add to modded custom groups

        addToItemGroup(ItemGroups.INGREDIENTS, BLOOD);
        addToItemGroup(ModItemGroup.ALCHEMY, BLOOD);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        TestMod.LOGGER.debug("Registering Mod Items for " + TestMod.MOD_ID);
        addItemsToItemGroup();
    }
}
