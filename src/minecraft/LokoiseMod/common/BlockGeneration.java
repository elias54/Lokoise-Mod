package LokoiseMod.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class BlockGeneration implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	{
		(new WorldGenMinable(Main.spawnLokoise.blockID, 4)).generate(world, random, blockX + random.nextInt(16), 10 + random.nextInt(30 - 10), blockZ + random.nextInt(16));
	}
}
