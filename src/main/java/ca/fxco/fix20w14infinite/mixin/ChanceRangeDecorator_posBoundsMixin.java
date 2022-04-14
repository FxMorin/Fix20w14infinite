package ca.fxco.fix20w14infinite.mixin;

import ca.fxco.fix20w14infinite.Utils;
import net.minecraft.world.level.levelgen.placement.nether.ChanceRangeDecorator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(ChanceRangeDecorator.class)
public class ChanceRangeDecorator_posBoundsMixin {


    @Redirect(
            method = "place(Ljava/util/Random;" +
                    "Lnet/minecraft/world/level/levelgen/feature/configurations/ChanceRangeDecoratorConfiguration;" +
                    "Lnet/minecraft/core/BlockPos;)Ljava/util/stream/Stream;",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Random;nextInt(I)I",
                    ordinal = 2
            )
    )
    private int mustBePositive(Random random, int bound) {
        return random.nextInt(Utils.posBound(bound));
    }
}
