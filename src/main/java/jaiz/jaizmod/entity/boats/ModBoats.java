package jaiz.jaizmod.entity.boats;


import jaiz.jaizmod.JaizMod;
import net.minecraft.resources.Identifier;

import java.util.List;

public class ModBoats {

    public static final Identifier MAHOGANY_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "mahogany");
    public static final Identifier DESERT_OAK_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "desert_oak");
    public static final Identifier ROTTEN_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "rotten");
    public static final Identifier CUMARU_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "cumaru");
    public static final Identifier EBONY_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "ebony");
    public static final Identifier FLAMBOYANT_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "flamboyant");
    public static final Identifier ATLAS_CEDAR_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "atlas_cedar");
    public static final Identifier BISMARCK_PALM_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "bismarck_palm");
    public static final Identifier CANNONBALL_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "cannonball");
    public static final Identifier SEQUOIA_BOAT_ID = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "sequoia");
    public static final List<Identifier> ALL = List.of(MAHOGANY_BOAT_ID, DESERT_OAK_BOAT_ID, ROTTEN_BOAT_ID,
            CUMARU_BOAT_ID, EBONY_BOAT_ID, FLAMBOYANT_BOAT_ID, ATLAS_CEDAR_BOAT_ID,
            BISMARCK_PALM_BOAT_ID, CANNONBALL_BOAT_ID, SEQUOIA_BOAT_ID);
    public static void registerBoats(){
    }
}
