package com.ekilord.rift.mixin;

import biomesoplenty.api.block.BOPBlocks;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.level.feature.AbyssalBoulderFeature;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbyssalBoulderFeature.class)
public class AbyssalBoulderFeatureMixin {
    @Redirect(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    public boolean redirectPlace(BlockState instance, Block block) {
        return instance.equals(BOPBlocks.BLACK_SAND.get().defaultBlockState()) ||
                instance.equals(BOPBlocks.GLOWING_MOSS_BLOCK.get().defaultBlockState()) ||
                instance.equals(ACBlockRegistry.ABYSSMARINE.get().defaultBlockState());
    }
}
