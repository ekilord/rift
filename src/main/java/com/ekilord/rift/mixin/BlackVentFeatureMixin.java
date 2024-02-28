package com.ekilord.rift.mixin;

import biomesoplenty.api.block.BOPBlocks;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.level.feature.BlackVentFeature;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlackVentFeature.class)
public class BlackVentFeatureMixin {
    @Redirect(method = "place", at = @At(value = "INVOKE", target = "Ljava/lang/Object;equals(Ljava/lang/Object;)Z"))
    public boolean redirectPlace(Object instance, Object o) {
        return instance.equals(BOPBlocks.BLACK_SAND.get().defaultBlockState())||
                instance.equals(BOPBlocks.GLOWING_MOSS_BLOCK.get().defaultBlockState()) ||
                instance.equals(ACBlockRegistry.ABYSSMARINE.get().defaultBlockState());
    }
}
