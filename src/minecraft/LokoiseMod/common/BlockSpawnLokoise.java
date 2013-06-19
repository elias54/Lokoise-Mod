package LokoiseMod.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockSpawnLokoise extends Block{

	protected BlockSpawnLokoise(int par1, Material par3Material) {
		super(par1, par3Material);
	}

		public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
		{
			
			if (!par1World.isRemote)
			{
				EntityLokoise var6 = new EntityLokoise(par1World);
	             var6.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
	             par1World.spawnEntityInWorld(var6);
	             var6.spawnExplosionParticle();
			}
			super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
		}
	    public int quantityDropped(Random par1Random)
	    {
	        return 0;
	    }
	    
	    
}
