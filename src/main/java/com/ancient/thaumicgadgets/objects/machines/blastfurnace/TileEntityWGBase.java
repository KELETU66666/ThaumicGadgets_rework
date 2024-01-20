package com.ancient.thaumicgadgets.objects.machines.blastfurnace;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityWGBase extends TileEntity
{
	@Override
	public void readFromNBT(NBTTagCompound tags)
	{
		super.readFromNBT(tags);
		readCustomNBT(tags);
	}

	public abstract void readCustomNBT(NBTTagCompound tags);

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tags)
	{
		super.writeToNBT(tags);
		writeCustomNBT(tags);

		return tags;
	}

	public abstract void writeCustomNBT(NBTTagCompound tags);
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new SPacketUpdateTileEntity(this.pos, 3, nbttagcompound);
	}
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
    {
		this.readFromNBT(pkt.getNbtCompound());
    }
}