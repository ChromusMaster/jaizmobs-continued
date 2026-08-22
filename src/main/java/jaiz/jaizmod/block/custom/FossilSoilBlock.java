package jaiz.jaizmod.block.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FossilSoilBlock extends BrushableBlock {
    public FossilSoilBlock(Block baseBlock, SoundEvent brushingSound, SoundEvent brushingCompleteSound, Properties settings) {
        super(baseBlock, brushingSound, brushingCompleteSound, settings);
    }
}
