package techreborn.multiblocks;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import techreborn.api.multiblock.BaseMultiBlock;
import techreborn.init.ModBlocks;

import java.util.List;

public class MultiBlastfurnace extends BaseMultiBlock {

    public MultiBlastfurnace(TileEntity parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return "BlastFurnaceMultiBlock";
    }

    @Override
    public boolean checkIfComplete() {
        return getController().getWorldObj().getBlock(getController().xCoord, getController().yCoord + 1, getController().zCoord) == ModBlocks.MachineCasing;
    }


    @Override
    public List<TileEntity> getTiles() {
        return null;
    }

    @Override
    public void recompute() {
        com
    }
}