package LokoiseMod.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import LokoiseMod.common.EntityLokoise;

public class RenderLokoise extends RenderBiped
{
	public static final ResourceLocation texture = new ResourceLocation("thelokoisemod", "textures/entity/Lokoise.png");
	
    public RenderLokoise(ModelBiped modelbase, float f)
    {
    	super(modelbase, f);
    }

    public void renderNamehereA(EntityLokoise entity, double d, double d1, double d2, float f, float f1)
    {
    	super.doRenderLiving(entity, d, d1, d2, f, f1);
            
    	if(entity.mobName.length() > 0 && entity.mobName != "")
    	{
    		renderLivingLabel(entity, entity.mobName, d, d1, d2, 64);
    	}       
    }
    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
    	super.doRenderLiving((EntityLokoise) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
    	renderNamehereA((EntityLokoise)entity, d, d1, d2, f, f1);
    }
   
    protected void preRenderScale(EntityLokoise entity, float f)
    {
    	GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    protected void preRenderCallback(EntityLivingBase entityliving, float f)
    {
    	preRenderScale((EntityLokoise)entityliving, f);
    }

    public ResourceLocation getTexture(EntityLokoise lokoise)
    {
    	return texture;
    }
    
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		// TODO Auto-generated method stub
		return getTexture((EntityLokoise)entity);
	}
}
