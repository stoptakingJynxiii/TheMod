package net.suzi.themod.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.suzi.themod.TheMod;
import net.suzi.themod.item.custom.*;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheMod.MOD_ID);


    //items
    public static final RegistryObject<Item> SOUL = ITEMS.register("soul",
            ()  -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EXTINGUISHED_ROD = ITEMS.register("extinguished_rod",
            ()  -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ICE_ROD = ITEMS.register("ice_rod",
            ()  -> new FuelItem(new Item.Properties(), 100));

    public static final RegistryObject<Item> BURGER = ITEMS.register("burger",
            ()  -> new BurgerItem(new Item.Properties().food(ModFoods.BURGER)));

    public static final RegistryObject<Item> BLUE_ROSE = ITEMS.register("blue_rose",
            ()  -> new BlueRoseItem(ModToolTiers.ROSE_TIER, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
