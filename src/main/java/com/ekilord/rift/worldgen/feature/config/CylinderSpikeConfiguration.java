package com.ekilord.rift.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class CylinderSpikeConfiguration implements FeatureConfiguration {
    public static final Codec<CylinderSpikeConfiguration> CODEC = RecordCodecBuilder.create((config) -> {
        return config.group(Codec.INT.fieldOf("minRadius").forGetter((property) -> {
            return property.minRadius;
        }), Codec.INT.fieldOf("maxRadius").forGetter((property) -> {
            return property.maxRadius;
        })).apply(config, CylinderSpikeConfiguration::new);
    });
    private final int minRadius;
    private final int maxRadius;

    public CylinderSpikeConfiguration(int minRadius, int maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    public int getMinRadius() {
        return this.minRadius;
    }

    public int getMaxRadius() {
        return this.maxRadius;
    }
}
