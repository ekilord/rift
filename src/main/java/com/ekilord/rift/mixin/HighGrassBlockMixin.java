package com.ekilord.rift.mixin;

import biomesoplenty.common.block.HighGrassBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HighGrassBlock.class)
public class HighGrassBlockMixin {
    @Redirect(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/ForgeHooks;onCropsGrowPre(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Z)Z"))
    public boolean redirectRandomTick(Level level, BlockPos pos, BlockState state, boolean def) {
        if (level.dimension().location().toString().equals("rift:tadmor")) return false;
        else return ForgeHooks.onCropsGrowPre(level, pos, state, def);
    }
}
