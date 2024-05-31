package com.ekilord.rift.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record CanyonArchConfiguration(int minLength, int maxLength) implements FeatureConfiguration {
    public static final Codec<CanyonArchConfiguration> CODEC = RecordCodecBuilder.create((config) -> {
        return config.group(Codec.INT.fieldOf("minLength").forGetter((property) -> {
            return property.minLength;
        }), Codec.INT.fieldOf("maxLength").forGetter((property) -> {
            return property.maxLength;
        })).apply(config, CanyonArchConfiguration::new);
    });
}
