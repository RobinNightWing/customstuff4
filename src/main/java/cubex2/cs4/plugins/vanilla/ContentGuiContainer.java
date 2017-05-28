package cubex2.cs4.plugins.vanilla;

import com.google.common.collect.Lists;
import cubex2.cs4.plugins.vanilla.gui.*;
import cubex2.cs4.plugins.vanilla.tileentity.FieldSupplier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ContentGuiContainer extends ContentGuiBase
{
    public int width = 176;
    public int height = 166;
    public List<SlotData> slots = Lists.newArrayList();
    public List<Label> labels = Lists.newArrayList();
    public List<FluidDisplay> fluidDisplays = Lists.newArrayList();
    public List<ShiftClickRule> shiftClickRules = Lists.newArrayList();
    public List<ProgressBar> progressBars = Lists.newArrayList();
    public ResourceLocation bg = null;
    public int bgTexX = 0;
    public int bgTexY = 0;

    @Override
    protected Object getServerGuiElement(EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te != null && te instanceof ItemHandlerSupplier && te instanceof FieldSupplier)
        {
            return createContainer(te, player);
        }

        return null;
    }

    @Override
    protected Object getClientGuiElement(EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te != null && te instanceof ItemHandlerSupplier && te instanceof FieldSupplier)
        {
            return new GuiContainerCS4(this, createContainer(te, player), (ProgressBarSource) te, (FluidSource) te);
        }

        return null;
    }

    private ContainerGui createContainer(TileEntity te, EntityPlayer player)
    {
        return new ContainerGui(this, (ItemHandlerSupplier) te, (FluidSource) te, (FieldSupplier) te, player);
    }
}
