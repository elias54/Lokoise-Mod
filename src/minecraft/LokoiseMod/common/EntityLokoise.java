package LokoiseMod.common;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityLokoise extends EntityMob
{
    public static ItemStack equippedItems[];
    public static int currentItem;
	public boolean hurted;
	public static String mobName;
    
    public EntityLokoise(World world)

    {
        super(world);
        this.mobName = "Lokoise";
        this.setEntityHealth(30F);
        this.currentItem = rand.nextInt(equippedItems.length);
        this.hurted = false;
    }
    
    @Override
    protected Entity findPlayerToAttack()
    {
    	EntityPlayer player = worldObj.getClosestPlayerToEntity(this, 16D);
    	return player != null ? super.findPlayerToAttack() : null;
    }
    
    public void updateEntityActionState()
    {
    	super.updateEntityActionState();
    	List list = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.getBoundingBox(this.posX, this.posY, this.posZ, this.posX + 1, this.posY + 1, this.posZ + 1).expand(32D, 8D, 32D));
    	Entity entity = (Entity)list.get(rand.nextInt(list.size()));
    	if(!list.isEmpty() && !(entity instanceof EntityLokoise))
    	{
    		entityToAttack = entity;
    	}
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource sourceOfDamage, float f)
    {
    	hurted = true;
        Entity entity = sourceOfDamage.getEntity();
        entityToAttack = entity;
        if (entity != null)
        {
            double d = -MathHelper.sin((entity.rotationYaw * (float)Math.PI) / 180F);
            double d1 = MathHelper.cos((entity.rotationYaw * (float)Math.PI) / 180F);
            motionX = d * 0.5D;
            motionZ = d1 * 0.5D;
        }
    	return super.attackEntityFrom(sourceOfDamage, f);
    }
    
    public void goToEntity(double d, double d1, double d2)
    {
    	this.moveEntity(d, d1, d2);
    }
    
    public void smoke()
    {
    	for (int l = 0; l< 2; l++)
    	{
    		worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ, 0.0000D, 0.1111D, 0.0D);
    		worldObj.spawnParticle("explode", this.posX, this.posY, this.posZ, 0.0000D, 0.1111D, 0.0D);
    		worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ, 0.0000D, 0.1111D, 0.0D);
    		worldObj.spawnParticle("explode", this.posX, this.posY, this.posZ, 0.0000D, 0.1111D, 0.0D);
    		worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ, 0.0000D, 0.1111D, 0.0D);
    	}
    }
    
    @Override
    public void attackEntity(Entity entity, float f)
    {
    	this.fallDistance = -25F;
    	if(onGround)
    	{
    		this.motionY += 0.00000008565252D;
    		smoke();
    	}
    	if(handleWaterMovement())
    	{
    		this.motionY += 0.20000008565252D;
    	}
    	super.attackEntity(entity, f);
    }
    protected String getLivingSound()
    {
		return "thelokoisemod:lokoisew";
    }
    protected String getHurtSound()
    {
		return "thelokoisemod:lokoiseh";
    }
    
    protected String getDeathSound()
    {
		return "thelokoisemod:lokoised";
    }

    protected float getSoundVolume()
    {
        return 1.5F;
    }
    public ItemStack getHeldItem() 
    {
		return this.equippedItems[currentItem];
    }
    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        
        switch (this.rand.nextInt(11))
        {
        case 1:
            	return Main.CD_TousLesZombies.itemID;
		case 2:
            	return Main.CD_BugDeChunks.itemID;
		case 3:
            	return Main.CD_LeJournalDUnNaufragay.itemID;
		case 4:
            	return Main.CD_JAimeLeCreep.itemID;
		case 5:
            	return Main.CD_JGeekUnMax.itemID;
		case 6:
            	return Main.CD_JSuisSeanKevin.itemID;
		case 7:
            	return Main.CD_Acta.itemID;
		case 8:
        		return Main.CD_JeMeGive.itemID;
		case 9:
        		return Main.CD_MusiqueBonusMinefight.itemID;
		case 10:
				return Main.CD_UnBanquetPresqueParfait.itemID;
		case 0:
			    return Main.CD_JFaitDesPellesEnDiams.itemID;
		default:
				return Block.dirt.blockID;
        }          
    }
    @Override
    protected void dropRareDrop(int par1)
    {
        this.dropItem(Item.diamond.itemID, 1);
    }
    
    static {
        	equippedItems = (new ItemStack[] {
        			new ItemStack(Item.diamond, 1), 
        			new ItemStack (Item.emerald, 1),
        			new ItemStack (Item.swordDiamond, 1)
        	});
    }
    protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1D);
    }
}
