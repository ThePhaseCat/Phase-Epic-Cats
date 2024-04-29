package phase.phase_epic_cat.event;

import lombok.Getter;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import phase.phase_epic_cat.PhaseEpicCat;
import phase.phase_epic_cat.accessor.MinecraftServerTimerAccess;
import net.minecraft.server.world.ServerWorld;

public class PhaseEpicCatEventHandler implements ServerWorldEvents.Load, ServerLifecycleEvents.ServerStopping {

    @Getter
    private MinecraftServer server;
    private MinecraftServerTimerAccess timerAccess;
    public static final int DAY_TIME = 18000;

    public void doDaytimeEvents(MinecraftServer server) {
        PhaseEpicCat.LOGGER.info("It's daytime!");
        setDayTimer();
    }

    @Override
    public void onServerStopping(MinecraftServer server) {
        PhaseEpicCat.LOGGER.info("Server stopping...");
    }

    @Override
    public void onWorldLoad(MinecraftServer server, ServerWorld world) {
        this.server = server;
        timerAccess = ((MinecraftServerTimerAccess) server);
        setDayTimer();
        PhaseEpicCat.LOGGER.info("World loaded!");
    }

    /**
     * Sets the nighttime timer to the next night
     * @return Number of ticks until night, or -1 on failure
     */
    public long setDayTimer() {
        if (server == null) {
            throw new NullPointerException(PhaseEpicCat.MOD_ID + " server was null.");
        }
        if (timerAccess == null) {
            throw new NullPointerException(PhaseEpicCat.MOD_ID + " timerAccess was null.");
        }
        long timerLength;
        long currentTime = server.getOverworld().getTimeOfDay() % 24000;
        if (currentTime > DAY_TIME) { // If we've passed DAY_TIME
            timerLength = (24000 - currentTime) + DAY_TIME; // (time left in this day) + (time from morning til DAY_TIME) = time until tomorrow's DAY_TIME
        } else {
            if (currentTime == 0) { // It's midnight
                PhaseEpicCat.LOGGER.info("It's midnight!");
                timerLength = 24000;
            } else { // It's before midnight
                timerLength = DAY_TIME - currentTime; // DAY_TIME - (current time) = time until midnight
            }
        }

        timerAccess.phaseEpicCat_setTimer(timerLength);
        PhaseEpicCat.LOGGER.info("Timer set to " + timerLength + " ticks");
        return timerLength;
    }
}
