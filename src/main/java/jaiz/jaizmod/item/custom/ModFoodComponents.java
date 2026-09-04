package jaiz.jaizmod.item.custom;


import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents{

    public static final FoodProperties RARE_SPICES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build();
    public static final FoodProperties GOURMET_MEAL = new FoodProperties.Builder().nutrition(12).saturationModifier(1.4f).build();

    public static final FoodProperties COCOON = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build();

    public static final FoodProperties TEA = new FoodProperties.Builder().nutrition(8).saturationModifier(0.7f).alwaysEdible().build();
    public static final FoodProperties WITHER_ROSE_TEA = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).alwaysEdible().build();
    public static final FoodProperties SPORE_BLOSSOM_TEA = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).alwaysEdible().build();
    public static final FoodProperties GLOW_BERRY_TEA = new FoodProperties.Builder().nutrition(10).saturationModifier(0.6f).alwaysEdible().build();
    public static final FoodProperties TORCH_FLOWER_TEA = new FoodProperties.Builder().nutrition(8).saturationModifier(0.7f).alwaysEdible().build();
    public static final FoodProperties PITCHER_PLANT_TEA = new FoodProperties.Builder().nutrition(8).saturationModifier(0.7f).alwaysEdible().build();
    public static final FoodProperties NETHER_FUNGAL_TEA = new FoodProperties.Builder().nutrition(8).saturationModifier(0.7f).alwaysEdible().build();
    public static final FoodProperties CHORUS_TEA = new FoodProperties.Builder().nutrition(8).saturationModifier(0.7f).alwaysEdible().build();

    public static final FoodProperties SNIFFER_MEAT = new FoodProperties.Builder().nutrition(8).saturationModifier(0.5f).build();
    public static final FoodProperties COOKED_SNIFFER_MEAT = new FoodProperties.Builder().nutrition(12).saturationModifier(1.0f).build();
    public static final FoodProperties GUARANA_FRUIT = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build();
    public static final FoodProperties GUARANA_SODA = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).alwaysEdible().build();
    /*
    Reserved for future mechanics involving the new tree species.
    public static final FoodProperties EBONY_FRUIT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build();
    public static final FoodProperties BISMARCK_PALM_FRUIT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.15f).build();
    public static final FoodProperties CANNONBALL_PULP = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build();
    public static final FoodProperties SEQUOIA_CONE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.15f).build();
    */
}
