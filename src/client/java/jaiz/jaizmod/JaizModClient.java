package jaiz.jaizmod;

import com.terraformersmc.terraform.boat.api.TerraformBoatClientHelper;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.ModModelLayers;
import jaiz.jaizmod.entity.bandit.Bandit;
import jaiz.jaizmod.entity.bandit.BanditRenderer;
import jaiz.jaizmod.entity.boats.ModBoats;
import jaiz.jaizmod.entity.butterfly.Butterfly;
import jaiz.jaizmod.entity.butterfly.ButterflyRenderer;
import jaiz.jaizmod.entity.caterpillar.Caterpillar;
import jaiz.jaizmod.entity.caterpillar.CaterpillarRenderer;
import jaiz.jaizmod.entity.dragonfly.DragonFly;
import jaiz.jaizmod.entity.dragonfly.DragonflyRenderer;
import jaiz.jaizmod.entity.firefly.Fireflies;
import jaiz.jaizmod.entity.firefly.FireflyRenderer;
import jaiz.jaizmod.entity.fruit_bat.FruitBat;
import jaiz.jaizmod.entity.fruit_bat.FruitBatRenderer;
import jaiz.jaizmod.entity.mason_mouth.MasonMouthRenderer;
import jaiz.jaizmod.entity.mason_mouth.Masonmouth;
import jaiz.jaizmod.entity.snail.Snail;
import jaiz.jaizmod.entity.snail.SnailRenderer;
import jaiz.jaizmod.particle.FireFlyParticle;
import jaiz.jaizmod.particle.SproutParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.AshParticle;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.particle.WaterDropParticle;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.block.Blocks;
import java.util.List;

public class JaizModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		TerraformBoatClientHelper.registerModelLayers(ModBoats.MAHOGANY_BOAT_ID);
		TerraformBoatClientHelper.registerModelLayers(ModBoats.ROTTEN_BOAT_ID);
		TerraformBoatClientHelper.registerModelLayers(ModBoats.DESERT_OAK_BOAT_ID);

		EntityRendererRegistry.register(ModEntities.BUTTERFLY, ButterflyRenderer::new);
		ModelLayerRegistry.registerModelLayer(ModModelLayers.BUTTERFLY, Butterfly::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.CATERPILLAR, CaterpillarRenderer::new);
		ModelLayerRegistry.registerModelLayer(ModModelLayers.CATERPILLAR, Caterpillar::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.DRAGONFLY, DragonflyRenderer::new);
		ModelLayerRegistry.registerModelLayer(ModModelLayers.DRAGONFLY, DragonFly::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.FIRE_FLY_SWARM, FireflyRenderer::new);
		ModelLayerRegistry.registerModelLayer(ModModelLayers.FIRE_FLY_SWARM, Fireflies::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.SNAIL, SnailRenderer::new);
		ModelLayerRegistry.registerModelLayer(ModModelLayers.SNAIL, Snail::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.GUANO, ThrownItemRenderer::new);
		EntityRendererRegistry.register(ModEntities.GLOWBALL, ThrownItemRenderer::new);
		EntityRendererRegistry.register(ModEntities.DYNAMITE, ThrownItemRenderer::new);

		EntityRendererRegistry.register(ModEntities.FRUIT_BAT, FruitBatRenderer::new);
		ModelLayerRegistry.registerModelLayer(ModModelLayers.FRUIT_BAT, FruitBat::getTexturedModelData);

		BlockColorRegistry.register(List.of(BlockTintSources.foliage()), ModBlocks.MAHOGANY_LEAVES,
				ModBlocks.DESERT_OAK_LEAVES, ModBlocks.IVY, ModBlocks.UNDERGROWTH, Blocks.LILY_PAD);

		EntityRendererRegistry.register(ModEntities.MASON_MOUTH, MasonMouthRenderer::new);
		ModelLayerRegistry.registerModelLayer(ModModelLayers.MASON_MOUTH, Masonmouth::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.BANDIT, BanditRenderer::new);
		ModelLayerRegistry.registerModelLayer(ModModelLayers.BANDIT, Bandit::getTexturedModelData);

		ParticleProviderRegistry.getInstance().register(JaizMod.STINK_PARTICLE, AshParticle.Provider::new);
		ParticleProviderRegistry.getInstance().register(JaizMod.STINK_ITEM_PARTICLE, WaterDropParticle.Provider::new);
		ParticleProviderRegistry.getInstance().register(JaizMod.SLIME_DRIP_PARTICLE, WaterDropParticle.Provider::new);
		ParticleProviderRegistry.getInstance().register(JaizMod.AMETHYST_SPARKLE_PARTICLE, EndRodParticle.Provider::new);
		ParticleProviderRegistry.getInstance().register(JaizMod.FIREFLY_PARTICLE, FireFlyParticle.FireFlyParticleFactory::new);
		ParticleProviderRegistry.getInstance().register(JaizMod.SPROUT_PARTICLE, SproutParticle.SproutParticleFactory::new);
		ParticleProviderRegistry.getInstance().register(JaizMod.DRY_LEAF_PARTICLE, FallingLeavesParticle.PaleOakProvider::new);
		ParticleProviderRegistry.getInstance().register(JaizMod.BLOOMING_IVY_PARTICLE, FallingLeavesParticle.PaleOakProvider::new);
		ParticleProviderRegistry.getInstance().register(JaizMod.DEAD_LEAF_PARTICLE, FallingLeavesParticle.PaleOakProvider::new);
		ParticleProviderRegistry.getInstance().register(JaizMod.SNOW_PARTICLE, FallingLeavesParticle.PaleOakProvider::new);

	}

}
