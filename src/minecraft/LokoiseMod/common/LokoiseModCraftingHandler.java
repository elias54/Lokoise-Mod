package LokoiseMod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class LokoiseModCraftingHandler implements ICraftingHandler{

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		int itemID = item.itemID;
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
        if(itemID == Main.CD_UnBanquetPresqueParfait.itemID)
        {
                player.addStat(Main.UnBanquetPresqueParfait , 1);
        }
        if(itemID == Main.CD_MusiqueBonusMinefight.itemID)
        {
                player.addStat(Main.MusiqueBonusMinefight , 1);
        }
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

}
