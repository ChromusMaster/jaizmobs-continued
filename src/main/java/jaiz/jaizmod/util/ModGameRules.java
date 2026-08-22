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


    public static void registerGamerules(){
    }
}
