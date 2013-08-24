package LokoiseMod.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class CustomItemRecord extends ItemRecord {

	/** List of all record items and their names. */
	private static final Map records = new HashMap();

	/** The name of the record. */
	public final String recordName;
	
	public String recordTex;

	protected CustomItemRecord(int par1, String par2Str, String s2) {
		super(par1, par2Str);
		this.recordName = par2Str;
		this.recordTex = s2;
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabMisc);
		records.put(par2Str, this);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Gets an icon index based on an item's damage value
	 */
	public Icon getIconFromDamage(int par1) {
		return this.itemIcon;
	}

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack par1ItemStack, 
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		if (par3World.getBlockId(par4, par5, par6) == Block.jukebox.blockID
				&& par3World.getBlockMetadata(par4, par5, par6) == 0) {
			if (par3World.isRemote) {
				return true;
			} else {
				((BlockJukeBox) Block.jukebox).insertRecord(par3World, par4,
						par5, par6, par1ItemStack);
				par3World.playAuxSFXAtEntity((EntityPlayer) null, 1005, par4,
						par5, par6, this.itemID);
				--par1ItemStack.stackSize;
				return true;
			}
		} else {
			return false;
		}
	}

	@SideOnly(Side.CLIENT)
	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
	{
		par3List.add(this.getRecordTitle());
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Return the title for this record.
	 */
	public String getRecordTitle() 
	{
		if(this.recordName == "thelokoisemod:BugDeChunk")
		{
			return "Lokoise - Bug de chunk";
		}
		if(this.recordName == "thelokoisemod:J'AimeLeCreep")
		{
			return "Lokoise - J'aime le creep";
		}
		if(this.recordName == "thelokoisemod:JeMeGive")
		{
			return "Lokoise - Je me give";
		}
		if(this.recordName == "thelokoisemod:J'GeekUnMax")
		{
			return "Lokoise - J'geek un max";
		}
		if(this.recordName == "thelokoisemod:J'SuisSeanKevin")
		{
			return "Lokoise - J'suis Sean-Kevin";
		}
		if(this.recordName == "thelokoisemod:TousLesZombies")
		{
			return "Lokoise - Tout les zombies";
		}
		if(this.recordName == "thelokoisemod:Acta")
		{
			return "Lokoise - Acta";
		}
		if(this.recordName == "thelokoisemod:LeJournalD'UnNaufragay")
		{
			return "Lokoise - Le journal d'un Naufragay";
		}
		if(this.recordName == "thelokoisemod:J'faitDesPellesEnDiam's")
		{
			return "Lokoise - J'fais des pelles en diam's";
		}
		if(this.recordName == "thelokoisemod:UnBanquetPresqueParfait")
		{
			return "Lokoise - Un banquet presque parfait";
		}
		if(this.recordName == "thelokoisemod:MusiqueBonusMinefight")
		{
			return "Lokoise - Minefight bonus";
		}
		if(this.recordName == "thelokoisemod:UnDebitToutPourri")
		{
			return "Lokoise - Un d\351bit tout pourri";
		}
		return this.recordName;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Return an item rarity from EnumRarity
	 */
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Return the record item corresponding to the given name.
	 */
	public static ItemRecord getRecord(String par0Str) {
		return (ItemRecord) records.get(par0Str);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("record_" + recordTex);
	}

}