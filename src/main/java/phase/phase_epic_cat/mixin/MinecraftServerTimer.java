package phase.phase_epic_cat.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

import phase.phase_epic_cat.PhaseEpicCat;
import phase.phase_epic_cat.accessor.MinecraftServerTimerAccess;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerTimer implements MinecraftServerTimerAccess {
    @Unique
    private long phaseEpicCat_ticksUntilDay;

    @Inject(method = "tick", at = @At("HEAD"))
    private void phaseEpicCat_onTick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        if (--this.phaseEpicCat_ticksUntilDay <= 0L) {
            PhaseEpicCat.LOGGER.info("MinecraftServerTimer mixin tick");
            PhaseEpicCat.EVENT_HANDLER.doDaytimeEvents((MinecraftServer) (Object) this);
        }
    }

    @Unique
    @Override
    public void phaseEpicCat_setTimer(long ticksUntilDay) {
        PhaseEpicCat.LOGGER.info("Setting timer to " + ticksUntilDay + " ticks");
        this.phaseEpicCat_ticksUntilDay = ticksUntilDay;
    }
}
