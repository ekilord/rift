package com.ekilord.rift.mixin;

import biomesoplenty.api.block.BOPBlocks;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.level.feature.TubeWormFeature;
import net.minecraft.world.level.WorldGenLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TubeWormFeature.class)
public class TubeWormFeatureMixin {
    @Redirect(method = "place", at = @At(value = "INVOKE", target = "Ljava/lang/Object;equals(Ljava/lang/Object;)Z"))
    public boolean redirectPlaceEquals(Object instance, Object o) {
        return instance.equals(BOPBlocks.BLACK_SAND.get().defaultBlockState()) || instance.equals(BOPBlocks.GLOWING_MOSS_BLOCK.get().defaultBlockState()) || instance.equals(ACBlockRegistry.ABYSSMARINE.get().defaultBlockState());
    }

    @Redirect(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/WorldGenLevel;getSeaLevel()I"))
    public int redirectPlaceGetSeaLevel(WorldGenLevel instance) {
        return 350;
    }

    @Redirect(method = "growWorm", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/WorldGenLevel;getSeaLevel()I"))
    public int redirectGrowWormGetSeaLevel(WorldGenLevel instance) {
        return 350;
    }
}
