package com.ekilord.rift.block;

import com.ekilord.rift.Rift;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RiftBlocks {
    //BLOCKS
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Rift.MOD_ID);
    public static final RegistryObject<Block> KOMATITE = BLOCKS.register("komatite", () -> new Block(BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> PHONOLITE = BLOCKS.register("phonolite", () -> new Block(BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> MOSSY_KOMATITE = BLOCKS.register("mossy_komatite", () -> new GrassBlock(BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.BASALT)));

    //BLOCKITEMS
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Rift.MOD_ID);
    public static final RegistryObject<BlockItem> KOMATITE_ITEM = ITEMS.register("komatite", () -> new BlockItem(KOMATITE.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PHONOLITE_ITEM = ITEMS.register("phonolite", () -> new BlockItem(PHONOLITE.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_KOMATITE_ITEM = ITEMS.register("mossy_komatite", () -> new BlockItem(MOSSY_KOMATITE.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
