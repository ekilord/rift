package com.ekilord.rift.worldgen.carver;

import com.ekilord.rift.Rift;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RiftCarvers {
    public static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, Rift.MOD_ID);
    public static final RegistryObject<WorldCarver<CanyonCarverConfiguration>> ROARING_CHASM = WORLD_CARVERS.register("roaring_chasm", () -> new ChasmCarver(CanyonCarverConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        WORLD_CARVERS.register(eventBus);
    }
}
