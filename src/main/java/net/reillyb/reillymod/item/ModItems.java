package net.reillyb.reillymod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.reillyb.reillymod.ReillyMod;
import net.reillyb.reillymod.item.ModItemGroups;

import java.util.function.Function;

public class ModItems {
    // add component to make food poisonous
    public static final ConsumableComponent POISON_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 6 * 20, 1), 1.0f))
            .build();

    // add component to make food always edible
    public static final FoodComponent POISON_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();


    // Register pink garnet using components
    public static final Item PINK_GARNET = registerItem("pink_garnet", Item::new, new Item.Settings()
        .food(POISON_FOOD_COMPONENT, POISON_FOOD_CONSUMABLE_COMPONENT));

    // Register raw pink garnet by appending functions
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", Item::new, new Item.Settings()
        .food(new FoodComponent.Builder()
                .nutrition(5)
                .saturationModifier(5)
                .alwaysEdible()
                .build()));

    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // create the item key
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ReillyMod.MOD_ID, name));
        // create the item instance
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        // register the item
        return Registry.register(Registries.ITEM, itemKey, item);
    }

    public static void registerModItems() {
        ReillyMod.LOGGER.info("Registering Mod Items for " + ReillyMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(fabricItemGroupEntries -> {
                    fabricItemGroupEntries.add(ModItems.RAW_PINK_GARNET);
                    fabricItemGroupEntries.add(ModItems.PINK_GARNET);
                });
        // Make raw and pink garnet usable with furnace
        FuelRegistryEvents.BUILD.register(((builder, context) -> {
            builder.add(ModItems.RAW_PINK_GARNET, 30 * 20);
            builder.add(ModItems.PINK_GARNET, 60 * 20);
        }));
    }
}
