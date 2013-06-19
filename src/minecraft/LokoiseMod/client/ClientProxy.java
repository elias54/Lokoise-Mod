package LokoiseMod.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import LokoiseMod.common.CommonProxy;
import LokoiseMod.common.EntityLokoise;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityLokoise.class, new RenderBiped(new ModelBiped(), 0.5f));
	}
}
