package com.ekilord.rift.mixin;

import biomesoplenty.common.worldgen.feature.misc.HugeLilyPadFeature;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HugeLilyPadFeature.class)
public class HugeLilyPadFeatureMixin {
    @Redirect(method = "checkSpace", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/BlockPos;getY()I"))
    public int redirectPlace(BlockPos instance) {
        return 0;
    }
}
