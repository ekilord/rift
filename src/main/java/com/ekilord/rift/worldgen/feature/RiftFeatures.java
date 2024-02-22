package com.ekilord.rift.worldgen.feature;

import com.ekilord.rift.Rift;
import com.ekilord.rift.worldgen.feature.config.CylinderSpikeConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RiftFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Rift.MOD_ID);
    public static final RegistryObject<Feature<CylinderSpikeConfiguration>> CYLINDER_SPIKE = FEATURES.register("cylinder_spike", () -> new CylinderSpikeFeature(CylinderSpikeConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
