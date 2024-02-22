package com.ekilord.rift.worldgen.feature;

import com.ekilord.rift.worldgen.feature.config.CylinderSpikeConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class CylinderSpikeFeature extends Feature<CylinderSpikeConfiguration> {
    public CylinderSpikeFeature(Codec<CylinderSpikeConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CylinderSpikeConfiguration> pContext) {
        CylinderSpikeConfiguration cylinderSpikeConfiguration = pContext.config();
        WorldGenLevel worldgenlevel = pContext.level();
        RandomSource randomsource = pContext.random();

        int radius = (int)Math.round(Math.random() *
                (cylinderSpikeConfiguration.getMaxRadius() - cylinderSpikeConfiguration.getMinRadius()) + cylinderSpikeConfiguration.getMinRadius());
        int height = (int)Math.round(Math.random() * 99 + 51);

        for(BlockPos blockpos : BlockPos.betweenClosed(new BlockPos(pContext.origin().getX() - radius, pContext.origin().getY() - 2, pContext.origin().getZ() - radius), new BlockPos(pContext.origin().getX() + radius, height, pContext.origin().getZ() + radius))) {
            if (blockpos.distToLowCornerSqr((double)pContext.origin().getX(), (double)blockpos.getY(), (double)pContext.origin().getZ()) <= (double)(radius * radius + 1) && blockpos.getY() < height) {
                this.setBlock(worldgenlevel, blockpos, Blocks.BONE_BLOCK.defaultBlockState());
            }
        }
        return true;
    }
}
