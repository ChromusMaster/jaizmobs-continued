package jaiz.jaizmod.worldgen.structure.placers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaiz.jaizmod.worldgen.structure.StructurePlacerTypes;
import java.util.List;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasBinding;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasLookup;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

public class JaizJungleTempleStructurePlacer extends Structure {

    public static final DimensionPadding DEFAULT_DIMENSION_PADDING = DimensionPadding.ZERO;
    public static final LiquidSettings DEFAULT_LIQUID_SETTINGS = LiquidSettings.APPLY_WATERLOGGING;
    public static final int MAX_SIZE = 128;
    public static final int field_49155 = 0;
    public static final int MAX_GENERATION_DEPTH = 20;
    public static final MapCodec<JaizJungleTempleStructurePlacer> CODEC = RecordCodecBuilder.<JaizJungleTempleStructurePlacer>mapCodec(
                    instance -> instance.group(
                                    settingsCodec(instance),
                                    StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                                    Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                                    Codec.intRange(0, 20).fieldOf("size").forGetter(structure -> structure.size),
                                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                                    Codec.BOOL.fieldOf("use_expansion_hack").forGetter(structure -> structure.useExpansionHack),
                                    Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                                    JigsawStructure.MaxDistance.CODEC.fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter),
                                    Codec.list(PoolAliasBinding.CODEC).optionalFieldOf("pool_aliases", List.of()).forGetter(structure -> structure.poolAliasBindings),
                                    DimensionPadding.CODEC.optionalFieldOf("dimension_padding", DEFAULT_DIMENSION_PADDING).forGetter(structure -> structure.dimensionPadding),
                                    LiquidSettings.CODEC.optionalFieldOf("liquid_settings", DEFAULT_LIQUID_SETTINGS).forGetter(structure -> structure.liquidSettings)
                            )
                            .apply(instance, JaizJungleTempleStructurePlacer::new)
            )
            .validate(JaizJungleTempleStructurePlacer::validate);
    private final Holder<StructureTemplatePool> startPool;
    private final Optional<Identifier> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final boolean useExpansionHack;
    private final Optional<Heightmap.Types> projectStartToHeightmap;
    private final JigsawStructure.MaxDistance maxDistanceFromCenter;
    private final List<PoolAliasBinding> poolAliasBindings;
    private final DimensionPadding dimensionPadding;
    private final LiquidSettings liquidSettings;

    private static DataResult<JaizJungleTempleStructurePlacer> validate(JaizJungleTempleStructurePlacer structure) {
        int i = switch (structure.terrainAdaptation()) {
            case NONE -> 0;
            case BURY, BEARD_THIN, BEARD_BOX, ENCAPSULATE -> 12;
        };
        return structure.maxDistanceFromCenter.horizontal() + i > 128
                ? DataResult.error(() -> "Structure size including terrain adaptation must not exceed 128")
                : DataResult.success(structure);
    }


    public JaizJungleTempleStructurePlacer(
            Structure.StructureSettings config,
            Holder<StructureTemplatePool> startPool,
            Optional<Identifier> startJigsawName,
            int size,
            HeightProvider startHeight,
            boolean useExpansionHack,
            Optional<Heightmap.Types> projectStartToHeightmap,
            JigsawStructure.MaxDistance maxDistanceFromCenter,
            List<PoolAliasBinding> poolAliasBindings,
            DimensionPadding dimensionPadding,
            LiquidSettings liquidSettings
    ) {
        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.useExpansionHack = useExpansionHack;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
        this.poolAliasBindings = poolAliasBindings;
        this.dimensionPadding = dimensionPadding;
        this.liquidSettings = liquidSettings;
    }


    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        int i = this.startHeight.sample(context.random(), new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));
        BlockPos blockPos = new BlockPos(chunkPos.getMinBlockX(), i, chunkPos.getMinBlockZ());
        Rotation blockRotation = Rotation.getRandom(context.random());
        BlockPos blockPosNotValid = this.getLowestYIn5by5BoxOffset7Blocks(context, blockRotation);

        if (blockPosNotValid.getY() < 100){
        return JigsawPlacement.addPieces(
                context,
                this.startPool,
                this.startJigsawName,
                this.size,
                blockPos,
                this.useExpansionHack,
                this.projectStartToHeightmap,
                this.maxDistanceFromCenter,
                PoolAliasLookup.create(this.poolAliasBindings, blockPos, context.seed()),
                this.dimensionPadding,
                this.liquidSettings
        );}
        return Optional.empty();
    }

    @Override
    public Optional<GenerationStub> findValidGenerationPoint(GenerationContext context) {
        return this.findGenerationPoint(context).filter(position -> isValidBiome(position, context));
    }

    private static boolean isValidBiome(GenerationStub result, GenerationContext context) {
        BlockPos blockPos = result.position();
        return context.validBiome()
                .test(
                        context.chunkGenerator()
                                .getBiomeSource()
                                .getNoiseBiome(
                                        QuartPos.fromBlock(blockPos.getX()),
                                        QuartPos.fromBlock(blockPos.getY()),
                                        QuartPos.fromBlock(blockPos.getZ()),
                                        context.randomState().sampler()
                                )
                );
    }


    @Override
    public StructureType<?> type() {
        return StructurePlacerTypes.JAIZ_JUNGLE_TEMPLE_STRUCTURE_PLACER;
    }
}
