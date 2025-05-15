package net.reillyb.reillymod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.reillyb.reillymod.ReillyMod;

public class ModItems {
// public static final Item REILLY_GEM = registerItem("reilly_gem", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ReillyMod.MOD_ID,"reilly_gem")))));
// public static final Item RAW_REILLY_GEM = registerItem("raw_reilly_gem", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ReillyMod.MOD_ID,"raw_reilly_gem")))));
public static final Item PINK_GARNET = registerItem("pink_garnet", new Item.Settings());
public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item.Settings());



//    private static Item registerItem(String name, Item item) {
//        return Registry.register(Registries.ITEM, Identifier.of(ReillyMod.MOD_ID, name), item);
//    }

    private static Item registerItem(String name, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ReillyMod.MOD_ID, name));
        Item item = new Item(itemSettings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);

    }

    public static void registerModItems() {
        ReillyMod.LOGGER.info("Registering Mod Items for " + ReillyMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
