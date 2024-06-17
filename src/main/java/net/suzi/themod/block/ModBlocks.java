package net.suzi.themod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.suzi.themod.TheMod;
import net.suzi.themod.block.custom.SoundBlock;
import net.suzi.themod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheMod.MOD_ID);

///BLOOOOOOOOOOCKS
    public static final RegistryObject<Block> BLUE_BLOCK = registerBlock("blue_block",
    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F)));

    public static final RegistryObject<Block> RED_BLOCK = registerBlock("red_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F)));

    public static final RegistryObject<Block> SOUL_BLOCK = registerBlock("soul_block",
            () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).sound(SoundType.METAL).strength(1.5F)));

    public static final RegistryObject<Block> CHILLED_OBSIDIAN = registerBlock("chilled_obsidian",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));

//I don't know what this code is below but lol?
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }



    public static void  register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}
