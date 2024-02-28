package com.ekilord.rift.mixin;

import com.github.alexmodguy.alexscaves.server.level.feature.AbyssalFloraFeature;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbyssalFloraFeature.class)
public class AbyssalFloraFeatureMixin {
    @Redirect(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/BlockPos;getY()I"))
    public int redirectPlace(BlockPos instance) {
        return 500;
    }
}
