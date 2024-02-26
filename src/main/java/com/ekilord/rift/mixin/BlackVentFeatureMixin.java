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
        return o.equals(BOPBlocks.BLACK_SAND.get()) || o.equals(BOPBlocks.GLOWING_MOSS_BLOCK.get()) || o.equals((Block) ACBlockRegistry.ABYSSMARINE.get());
    }
}
