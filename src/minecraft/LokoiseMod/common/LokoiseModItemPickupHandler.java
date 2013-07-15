package LokoiseMod.common;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import cpw.mods.fml.common.IPickupNotifier;

public class LokoiseModItemPickupHandler implements IPickupNotifier
{

	@ForgeSubscribe
	@Override
	public void notifyPickup(EntityItem item, EntityPlayer player) 
	{
		int itemID = item.getEntityItem().itemID;
        if(itemID == Main.CD_BugDeChunks.itemID)
        {
                player.addStat(Main.BugDeChunks , 1);
        }
        if(itemID == Main.CD_JAimeLeCreep.itemID)
        {
                player.addStat(Main.JAimeLeCreep , 1);
        }
        if(itemID == Main.CD_JeMeGive.itemID)
        {
                player.addStat(Main.JeMeGive , 1);
        }
        if(itemID == Main.CD_JGeekUnMax.itemID)
        {
                player.addStat(Main.JGeekUnMax , 1);
        }
        if(itemID == Main.CD_JSuisSeanKevin.itemID)
        {
                player.addStat(Main.JSuisSeanKevin , 1);
        }
        if(itemID == Main.CD_TousLesZombies.itemID)
        {
                player.addStat(Main.TousLesZombies , 1);
        }
        if(itemID == Main.CD_Acta.itemID)
        {
                player.addStat(Main.Acta , 1);
        }
        if(itemID == Main.CD_LeJournalDUnNaufragay.itemID)
        {
                player.addStat(Main.LeJournalDUnNaufragay , 1);
        }
        if(itemID == Main.CD_JFaitDesPellesEnDiams.itemID)
        {
                player.addStat(Main.JFaitDesPellesEnDiams , 1);
        }
	}
	
}
