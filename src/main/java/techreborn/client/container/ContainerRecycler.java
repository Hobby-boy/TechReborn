package techreborn.client.container;

import net.minecraft.entity.player.EntityPlayer;
import reborncore.client.gui.BaseSlot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import reborncore.client.gui.SlotOutput;
import reborncore.common.container.RebornContainer;
import techreborn.api.gui.SlotUpgrade;
import techreborn.tiles.teir1.TileRecycler;

public class ContainerRecycler extends RebornContainer
{

	public int connectionStatus;
	EntityPlayer player;
	TileRecycler tile;

	public ContainerRecycler(TileRecycler tileGrinder, EntityPlayer player)
	{
		super();
		tile = tileGrinder;
		this.player = player;

		// input
		this.addSlotToContainer(new BaseSlot(tileGrinder.inventory, 0, 56, 34));
		this.addSlotToContainer(new SlotOutput(tileGrinder.inventory, 1, 116, 34));

		// upgrades
		this.addSlotToContainer(new SlotUpgrade(tileGrinder.inventory, 2, 152, 8));
		this.addSlotToContainer(new SlotUpgrade(tileGrinder.inventory, 3, 152, 26));
		this.addSlotToContainer(new SlotUpgrade(tileGrinder.inventory, 4, 152, 44));
		this.addSlotToContainer(new SlotUpgrade(tileGrinder.inventory, 5, 152, 62));

		int i;

		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new BaseSlot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new BaseSlot(player.inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int id, int value)
	{
		if (id == 10)
		{
			this.connectionStatus = value;
		}
	}
}
