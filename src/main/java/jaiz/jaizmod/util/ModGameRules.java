package jaiz.jaizmod.util;

import jaiz.jaizmod.JaizMod;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;

public class ModGameRules {

    public static final GameRule<Boolean> DO_GLOWING_SQUID = GameRuleBuilder.forBoolean(false)
            .category(GameRuleCategory.MOBS)
            .buildAndRegister(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "do_glowing_squid"));

    public static final GameRule<Boolean> GIVE_WELCOME_GUIDE = GameRuleBuilder.forBoolean(true)
            .category(GameRuleCategory.MISC)
            .buildAndRegister(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "give_welcome_guide"));


    public static void registerGamerules(){
    }
}
