package ca.fxco.fix20w14infinite.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.TwistingVinesFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(TwistingVinesFeature.class)
public abstract class TwitstingVinesFeature_expensiveMixin {

    @Shadow
    private static void placeTwistingVines(LevelAccessor levelAccessor, Random random, BlockPos blockPos, int i, int j, int k) {}


    @Redirect(
            method = "Lnet/minecraft/world/level/levelgen/feature/TwistingVinesFeature;place(" +
                    "Lnet/minecraft/world/level/LevelAccessor;Ljava/util/Random;Lnet/minecraft/core/BlockPos;III)Z",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/levelgen/feature/TwistingVinesFeature;placeTwistingVines(" +
                            "Lnet/minecraft/world/level/LevelAccessor;Ljava/util/Random;" +
                            "Lnet/minecraft/core/BlockPos;III)V"
            )
    )
    private static void placeTwistingVinesLessExpensive(LevelAccessor levelAccessor, Random random, BlockPos blockPos, int i, int j, int k) {
        placeTwistingVines(levelAccessor, random, blockPos, Math.min(i,4), j, Math.min(k,8));
    }
}
