package com.ekilord.rift.worldgen.carver;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

import java.util.function.Function;

public class ChasmCarver extends WorldCarver<CanyonCarverConfiguration> {

    private final float probability = 0.05f;

    public ChasmCarver(Codec<CanyonCarverConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean carve(CarvingContext pContext, CanyonCarverConfiguration pConfig, ChunkAccess pChunk, Function<BlockPos, Holder<Biome>> pBiomeAccessor, RandomSource pRandom, Aquifer pAquifer, ChunkPos pChunkPos, CarvingMask pCarvingMask) {
        /*this.carveEllipsoid(pContext, pConfig, pChunk, pBiomeAccessor, pAquifer, 10, 10, 10, 10, 10, pCarvingMask, new CarveSkipChecker() {
            @Override
            public boolean shouldSkip(CarvingContext pContext, double pRelativeX, double pRelativeY, double pRelativeZ, int pY) {
                return false;
            }
        });*/
        return true;
    }

    @Override
    public boolean isStartChunk(CanyonCarverConfiguration pConfig, RandomSource pRandom) {
        return pRandom.nextFloat() <= probability;
    }
}
