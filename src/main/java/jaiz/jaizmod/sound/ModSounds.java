package jaiz.jaizmod.sound;

import com.google.common.collect.ImmutableList;
import jaiz.jaizmod.JaizMod;
import java.util.stream.IntStream;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;

import static net.minecraft.sounds.SoundEvents.GOAT_HORN_SOUND_VARIANTS;

public class ModSounds {

    public static ResourceKey<JukeboxSong> of(String id) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, id));

    }

    public static final SoundEvent AMETHYST_HORN = registerSoundEvent("amethyst_horn");
    public static final SoundEvent AIR_HORN = registerSoundEvent("air_horn");
    public static final SoundEvent ANCIENT_HORN = registerSoundEvent("ancient_horn");

    public static final SoundEvent SHIELD_DRUM = registerSoundEvent("shield_drum");

    public static final SoundEvent BANDIT_IDLE = registerSoundEvent("bandit_idle");
    public static final SoundEvent BANDIT_DAMAGE = registerSoundEvent("bandit_damage");
    public static final SoundEvent BANDIT_DEATH = registerSoundEvent("bandit_death");
    public static final SoundEvent BANDIT_TRADE = registerSoundEvent("bandit_trade_success");
    public static final SoundEvent BANDIT_TRADE_FAIL = registerSoundEvent("bandit_trade_fail");

    public static void registerSounds() {
        JaizMod.LOGGER.info(("Registering sounds for " + JaizMod.MOD_ID));
        ModSounds.registerReference("origami_hairball");
    }


    private static void registerReference(String name) {
        Identifier ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name);
        Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, ID, SoundEvent.createVariableRangeEvent(ID));
    }

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));

    }
}
