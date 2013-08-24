package LokoiseMod.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpawnLokoise extends Block{

	protected BlockSpawnLokoise(int par1, Material par3Material) {
		super(par1, par3Material);
	}

	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	{
			EntityLokoise lokoise = new EntityLokoise(par1World);
			lokoise.setLocationAndAngles(par2, par3, par4, lokoise.rotationYaw, 0.0F);
			par1World.spawnEntityInWorld(lokoise);
			lokoise.spawnExplosionParticle();
		super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
	}
	    public int quantityDropped(Random par1Random)
	    {
	        return 0;
	    }
	    @SideOnly(Side.CLIENT)
	    
	    public Icon getIcon(int side, int metadata)
	    {
	        return this.blockIcon = Block.oreDiamond.getBlockTextureFromSide(side);
	    }
	    
	    
}
