package ca.fxco.fix20w14infinite.mixin;

import ca.fxco.fix20w14infinite.Utils;
import net.minecraft.world.level.levelgen.feature.DiskReplaceFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(DiskReplaceFeature.class)
public class DiskReplaceFeature_posBoundsMixin {


    @Redirect(
            method = "place(Lnet/minecraft/world/level/LevelAccessor;" +
                    "Lnet/minecraft/world/level/chunk/ChunkGenerator;Ljava/util/Random;Lnet/minecraft/core/BlockPos;" +
                    "Lnet/minecraft/world/level/levelgen/feature/configurations/DiskConfiguration;)Z",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Random;nextInt(I)I"
            )
    )
    private int mustBePositive(Random random, int bound) {
        return random.nextInt(Utils.posBound(bound));
    }
}
