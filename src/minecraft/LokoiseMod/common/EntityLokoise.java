package LokoiseMod.common;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;


public class EntityLokoise extends EntityMob
{
    public static ItemStack equippedItems[];
    public static int equippedItem;
	
    public EntityLokoise(World world)

    {
        super(world);
        texture = "/mods/TheLokoiseMod/Lokoise.png";
        moveSpeed = 0.25F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
        this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));
        equippedItem = rand.nextInt(equippedItems.length);
    }
    
    public int getMaxHealth()
    {
        return 20;
    }

    @Override
    public int getAttackStrength(Entity entity)
    {
    	return 8;
    }

    protected boolean isAIEnabled()
    {
        return true;
    }

    int gLS = this.rand.nextInt(6);
    protected String getLivingSound()
    {
    	if ((gLS == 0)) {
    		
    		return "1l";
    		
    	} else if (gLS == 1){
    		
    		return "3l";
    		
    	} else if (gLS == 2){
    		
    		return "4l";
    		
    	} else if (gLS == 3){
    		
    		return "7l";
    		
    	} else if (gLS == 4){
    		
    		return "8l";
    		
    	} else if (gLS == 5){
    		
    		return "9l";
    		
    	} else
			
		return null;
    }
    int gHS = this.rand.nextInt(2);
    protected String getHurtSound()
    {
    	if ((gHS == 0)) {
    		
    		return "2l";
    		
    	} else if (gHS == 1){
    		
    		return "10l";
    		
    	} else
			
		return null;
    }
    
    int gDS = this.rand.nextInt(2);
    protected String getDeathSound()
    {
    	if ((gDS == 0)) {
    		
    		return "5l";
    		
    	} else if (gDS == 1){
    		
    		return "6l";
    		
    	} else
			
		return null;
    }

    protected float getSoundVolume()
    {
        return 1.5F;
    }
    public ItemStack getHeldItem() 
    {
		return equippedItems[equippedItem];
    }
    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        
        switch (this.rand.nextInt(9))
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
		case 0:
			    return Main.CD_JFaitDesPellesEnDiams.itemID;
        }
		return Block.dirt.blockID;
          
    }
    
    protected void dropRareDrop(int par1){
        this.dropItem(Item.diamond.itemID, 1);
    }
    
    static {
    	equippedItems = (new ItemStack[] {
    			new ItemStack(Item.diamond, 1), 
    			new ItemStack (Item.emerald, 1),
    			new ItemStack (Item.swordDiamond, 1)
    	});
    }
    
}
