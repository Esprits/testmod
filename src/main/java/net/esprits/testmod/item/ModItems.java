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

    public static final Item LAPIS_PHILOSOPHORUM = registerItem(
            "lapis_philosophorum",
            new Item(new Item.Settings()),
            // For vanilla groups
            //ItemGroups.FUNCTIONAL
            // For modded groups
            ModItemGroup.ALCHEMY
    );

    private static Item registerItem(String name, Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.debug("Registering Mod Items for " + TestMod.MOD_ID);
    }
}
