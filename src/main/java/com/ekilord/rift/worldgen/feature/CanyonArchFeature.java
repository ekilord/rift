package com.ekilord.rift.worldgen.feature;

import com.ekilord.rift.worldgen.feature.config.CanyonArchConfiguration;
import com.ekilord.rift.worldgen.feature.config.CylinderSpikeConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class CanyonArchFeature extends Feature<CanyonArchConfiguration> {
    public CanyonArchFeature(Codec<CanyonArchConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CanyonArchConfiguration> pContext) {
        CanyonArchConfiguration canyonArchConfiguration = pContext.config();
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockPos = pContext.origin();

        if (worldgenlevel.getBlockState(blockPos.north()).is(Blocks.AIR)) {
            BlockPos blockPos2 = blockPos;
            int i = 1;

            while (worldgenlevel.getBlockState(blockPos2.north()).is(Blocks.AIR)) {
                if (i > canyonArchConfiguration.maxLength()) return false;
                if (worldgenlevel.getBlockState(blockPos2).is(Blocks.AIR)) return false;
                blockPos2 = blockPos2.north();
                ++i;
            }
            if (i < canyonArchConfiguration.minLength()) return false;

            for (int k = 0; k < i; ++k) {
                this.setBlock(worldgenlevel, blockPos.north(k+1), Blocks.RED_GLAZED_TERRACOTTA.defaultBlockState());
            }
            return true;
        }

        return false;
    }
}
