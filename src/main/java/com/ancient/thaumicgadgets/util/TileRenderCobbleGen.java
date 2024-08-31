package com.ancient.thaumicgadgets.util;

import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruder;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileRenderCobbleGen extends TileEntitySpecialRenderer<TileEntityExtruder>
{
	public void renderTileEntityAt(TileEntityExtruder tile, double x, double y, double z)
	{
		GL11.glPushMatrix();

		Tessellator tes = Tessellator.getInstance();
		GL11.glDisable(GL11.GL_LIGHTING);
		//		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		int tick = tile == null ? 0 : tile.getWorkTime();
		GL11.glTranslatef((float)x, (float)y, (float)z);

		EnumFacing facing = tile == null ? EnumFacing.NORTH : getWorld().getBlockState(tile.getPos()).getValue(BlockHorizontal.FACING);
		switch(facing)
		{
		case NORTH:
			break;
		case SOUTH:
			GL11.glRotatef(180, 0, 1, 0);
			GL11.glTranslatef(-1, 0, -1);
			break;
		case EAST:
			GL11.glRotatef(270, 0, 1, 0);
			GL11.glTranslatef(0, 0, -1);
			break;
		case WEST:
			GL11.glRotatef(90, 0, 1, 0);
			GL11.glTranslatef(-1, 0, 0);
			break;
		default:
			break;
		}

		this.bindTexture(new ResourceLocation("thaumicgadgets", "textures/blocks/woodplain.png"));
		renderPixelBlock(tes, 0, 0, 0, 1, 0.1875, 1,0,0,1,0.1875);
		renderPixelBlock(tes, 0.0625, 0.1875, 0.0625, 0.9375, 0.3125, 0.9375,0,0,1,0.125);
		renderPixelBlock(tes, 0, 0.8125, 0, 1, 0.9375, 1,0,0,1,0.1875);

		this.bindTexture(new ResourceLocation("thaumcraft", "textures/blocks/arcane_stone_1.png"));
		renderPixelBlock(tes, 0, 1, 0, 1, 1, 1,0,0,1,1);
		renderPixelBlock(tes, 0, 0.9375, 0, 1, 0.999, 1,0,0,0.125,0.125);
		renderPixelBlock(tes, 0.0625, 0.3125, 0.0625, 0.9375, 0.3125, 0.9375,0.0625,0.0625,0.9375,0.9375);
		renderPixelBlock(tes, 0, 0.8125, 0, 1, 0.8125, 1,0,0,1,1);
		this.bindTexture(new ResourceLocation("thaumcraft", "textures/blocks/pedestal_top.png"));
		renderPixelBlock(tes, 0, 0.1875, 0, 0.125, 0.8125, 0.125,0,0,0.125,1);
		renderPixelBlock(tes, 0, 0.1875, 0.875, 0.125, 0.8125, 1,0,0,0.125,1);
		renderPixelBlock(tes, 0.875, 0.1875, 0, 1, 0.8125, 0.125,0,0,0.125,1);
		renderPixelBlock(tes, 0.875, 0.1875, 0.875, 1, 0.8125, 1,0,0,0.125,1);

		if(!facing.equals(EnumFacing.UP) && !facing.equals(EnumFacing.DOWN))
			this.bindTexture(new ResourceLocation("thaumcraft", "textures/blocks/levitator_top_on.png"));
		else
			this.bindTexture(new ResourceLocation("thaumcraft", "textures/blocks/levitator_side_on.png"));
		renderPixelBlock(tes, 0.125, 0.125, 0.0624, 0.875, 0.875, 0.0625, 0.125,0.125,0.875,0.875);
		this.bindTexture(new ResourceLocation("thaumcraft", "textures/blocks/levitator_side_on.png"));
		renderPixelBlock(tes, 0.125, 0.125, 0.9375, 0.875, 0.875, 0.9376, 0.125,0.125,0.875,0.875);
		renderPixelBlock(tes, 0.9375, 0.125, 0.125, 0.9376, 0.625, 0.875, 0.125,0.125,0.875,0.625);
		renderPixelBlock(tes, 0.0624, 0.125, 0.125, 0.0625, 0.625, 0.875, 0.125,0.125,0.875,0.625);

		this.bindTexture(new ResourceLocation("thaumicgadgets", "textures/models/bore.png"));
		if(facing.equals(EnumFacing.UP))
		{
			renderPixelBlock(tes, 0.375, 1, 0.375, 0.625, 1.125, 0.625, 0.859375,0.65625,0.8984375,0.71875);
			renderPixelBlock(tes, 0.375, 1.125, 0.375, 0.625, 1.125, 0.625, 0.828125,0.875,0.8671875,0.953125);
		}
		else if(facing.equals(EnumFacing.DOWN))
		{
			renderPixelBlock(tes, 0.375,-0.125, 0.375, 0.625, 0, 0.625, 0.859375,0.65625,0.8984375,0.71875);
			renderPixelBlock(tes, 0.375,-0.125, 0.375, 0.625,-0.125, 0.625, 0.828125,0.875,0.8671875,0.953125);
		}
		else
		{
			renderPixelBlock(tes, 0.4075, 0.4075, 0, 0.5925, 0.5925, 0.0624, 0.859375,0.65625,0.8984375,0.71875);
			renderPixelBlock(tes, 0.375, 0.375,-0.125, 0.625, 0.625, 0, 0.859375,0.65625,0.8984375,0.71875);
			renderPixelBlock(tes, 0.375, 0.375,-0.125, 0.625, 0.625,-0.125, 0.828125,0.875,0.8671875,0.953125);
		}

		if(tile==null || tile.getWorld().getRedstonePowerFromNeighbors(tile.getPos())>0 || tile.getWorld().isBlockPowered(tile.getPos()))
		{
			double slowTick = tick/4;
			double loopTick = slowTick*1.65;
			double inc = 1.0/512.0;
			GL11.glEnable(3042);
			GL11.glBlendFunc(770, 771);
			this.bindTexture(new ResourceLocation("textures/blocks/lava_flow.png"));
			renderPixelBlock(tes, 0.1875, 0.3125, 0.375, 0.3125, 0.8125, 0.625, .375,(loopTick*inc),.625,((loopTick+8)*inc));

			this.bindTexture(new ResourceLocation("textures/blocks/water_flow.png"));
			renderPixelBlock(tes, 0.6875, 0.3125, 0.375, 0.8125, 0.8125, 0.625, .375,(loopTick*inc),.625,((loopTick+8)*inc));
			GL11.glDisable(3042);

			this.bindTexture(new ResourceLocation("textures/blocks/cobblestone.png"));
			if(tick>32)
				renderPixelBlock(tes, 0.3125, 0.3125, 0.3125, 0.6875, 0.6875, 0.6875, 0,0,1,1);
		}

		GL11.glEnable(GL11.GL_LIGHTING);

		GL11.glPopMatrix();
	}

	public static void renderPixelBlock(Tessellator tes, double x,double y,double z,double pixelLengthX,double pixelLengthY,double pixelLengthZ,double uMin,double vMin,double uMax,double vMax)
	{
		double dXMin = x;
		double dXMax = pixelLengthX;
		double dYMin = y;
		double dYMax = pixelLengthY;
		double dZMin = z;
		double dZMax = pixelLengthZ;
		BufferBuilder buffer = tes.getBuffer();
		//Side YNeg
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		buffer.pos(dXMin, dYMin, dZMin).tex(uMin, vMin).endVertex();
		buffer.pos(dXMax, dYMin, dZMin).tex(uMax, vMin).endVertex();
		buffer.pos(dXMax, dYMin, dZMax).tex(uMax, vMax).endVertex();
		buffer.pos(dXMin, dYMin, dZMax).tex(uMin, vMax).endVertex();
		tes.draw();
		//Side YPos
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		buffer.pos(dXMin, dYMax, dZMin).tex(uMin, vMin).endVertex();
		buffer.pos(dXMin, dYMax, dZMax).tex(uMin, vMax).endVertex();
		buffer.pos(dXMax, dYMax, dZMax).tex(uMax, vMax).endVertex();
		buffer.pos(dXMax, dYMax, dZMin).tex(uMax, vMin).endVertex();
		tes.draw();
		//Side ZNeg
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		buffer.pos(dXMin, dYMin, dZMin).tex(uMin, vMin).endVertex();
		buffer.pos(dXMin, dYMax, dZMin).tex(uMin, vMax).endVertex();
		buffer.pos(dXMax, dYMax, dZMin).tex(uMax, vMax).endVertex();
		buffer.pos(dXMax, dYMin, dZMin).tex(uMax, vMin).endVertex();
		tes.draw();
		//Side ZPos
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		buffer.pos(dXMin, dYMin, dZMax).tex(uMin, vMin).endVertex();
		buffer.pos(dXMax, dYMin, dZMax).tex(uMax, vMin).endVertex();
		buffer.pos(dXMax, dYMax, dZMax).tex(uMax, vMax).endVertex();
		buffer.pos(dXMin, dYMax, dZMax).tex(uMin, vMax).endVertex();
		tes.draw();
		//Side XNeg
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		buffer.pos(dXMin, dYMin, dZMin).tex(uMin, vMin).endVertex();
		buffer.pos(dXMin, dYMin, dZMax).tex(uMax, vMin).endVertex();
		buffer.pos(dXMin, dYMax, dZMax).tex(uMax, vMax).endVertex();
		buffer.pos(dXMin, dYMax, dZMin).tex(uMin, vMax).endVertex();
		tes.draw();
		//Side XPos
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		buffer.pos(dXMax, dYMin, dZMin).tex(uMin, vMin).endVertex();
		buffer.pos(dXMax, dYMax, dZMin).tex(uMin, vMax).endVertex();
		buffer.pos(dXMax, dYMax, dZMax).tex(uMax, vMax).endVertex();
		buffer.pos(dXMax, dYMin, dZMax).tex(uMax, vMin).endVertex();
		tes.draw();
	}

	@Override
	public void render(TileEntityExtruder tileentity, double d0, double d1, double d2, float f, int i, float f1)
	{
		renderTileEntityAt(tileentity, d0, d1, d2);
	}

}