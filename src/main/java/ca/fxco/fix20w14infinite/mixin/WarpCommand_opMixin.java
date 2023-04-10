package ca.fxco.fix20w14infinite.mixin;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.commands.WarpCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WarpCommand.class)
public class WarpCommand_opMixin {

    @Redirect(
            method = "register",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/commands/Commands;literal(Ljava/lang/String;)" +
                            "Lcom/mojang/brigadier/builder/LiteralArgumentBuilder;"
            )
    )
    private static LiteralArgumentBuilder<CommandSourceStack> addPermissionCheck(String string) {
        return Commands.literal(string).requires(commandSourceStack -> commandSourceStack.hasPermission(2));
    }
}
