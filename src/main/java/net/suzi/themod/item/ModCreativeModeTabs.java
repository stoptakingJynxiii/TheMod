package net.suzi.themod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.suzi.themod.TheMod;
import net.suzi.themod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheMod.MOD_ID);

//WHERE I ADD ALL CUSTOM ITEMS TO CUSTOM TAB
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("themod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SOUL.get()))
                    .title(Component.translatable("creativetab.themod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SOUL.get());
                        output.accept(ModItems.BLUE_ROSE.get());
                        output.accept(ModItems.EXTINGUISHED_ROD.get());
                        output.accept(ModItems.ICE_ROD.get());
                        output.accept(ModItems.BURGER.get());

                        output.accept(ModBlocks.BLUE_BLOCK.get());
                        output.accept(ModBlocks.RED_BLOCK.get());
                        output.accept(ModBlocks.SOUL_BLOCK.get());
                        output.accept(ModBlocks.CHILLED_OBSIDIAN.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
