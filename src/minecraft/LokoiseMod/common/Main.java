package LokoiseMod.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.MODVERSION)

public class Main 
{
	
	public static final String MODID = "lokoisemod";
	public static final String MODNAME = "Lokoise Mod";
	public static final String MODVERSION = "v2";
	
	@SidedProxy(clientSide = "LokoiseMod.client.ClientProxy", serverSide = "LokoiseMod.common.CommonProxy", modId = MODID)

	public static CommonProxy proxy;
	
	@Instance(MODID)
	public static Main instance;
	
	public static Item CD_BugDeChunks,
				  	   CD_JAimeLeCreep,
				  	   CD_JeMeGive,
				  	   CD_JGeekUnMax,
				  	   CD_JSuisSeanKevin,
				  	   CD_TousLesZombies,
				  	   CD_Acta,
				  	   CD_LeJournalDUnNaufragay,
				  	   CD_JFaitDesPellesEnDiams;
	
	public static Block spawnLokoise;
	
	public int CD_BugDeChunksID,
	   		   CD_JAimeLeCreepID,
	   		   CD_JeMeGiveID,
	   		   CD_JGeekUnMaxID,
	   		   CD_JSuisSeanKevinID,
	   		   CD_TousLesZombiesID,
	   		   CD_ActaID,
	   		   CD_LeJournalDUnNaufragayID,
	   		   CD_JFaitDesPellesEnDiamsID,
	   		   spawnLokoiseID;

	
	
	/** Pre initialisation du mod **/
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try 
		{
			CD_BugDeChunksID = config.getItem("CD Bug de chunk ID", 5000).getInt();
			CD_JAimeLeCreepID =  config.getItem("CD J'aime le creep ID", 5001).getInt();
			CD_JeMeGiveID =  config.getItem("CD Je me give ID", 5002).getInt();
			CD_JGeekUnMaxID =  config.getItem("CD J'geek un max ID", 5003).getInt();
			CD_JSuisSeanKevinID =  config.getItem("CD J'suis Sean Kevin ID", 5004).getInt();
			CD_TousLesZombiesID =  config.getItem("CD Tous les zombies ID", 5005).getInt();
			CD_ActaID =  config.getItem("CD Acta ID", 5006).getInt();
			CD_LeJournalDUnNaufragayID =  config.getItem("CD Le journal d'un Naufragay ID", 5007).getInt();
			CD_JFaitDesPellesEnDiamsID =  config.getItem("CD J'fais des pelles en diams ID", 5008).getInt();
			spawnLokoiseID = config.getBlock("Spawn Lokoise Block ID", 2500).getInt();
		} 
		finally 
		{
			if(config.hasChanged())
			{
				config.save();
			}
		}
	}
	
	/** Initialisation du mod **/
	@Init
	public void init(FMLInitializationEvent event)
	{
		
		CD_BugDeChunks = (new CustomItemRecord(CD_BugDeChunksID, "1", "Bug De Chunk - By Lokoise")).setUnlocalizedName("record");
	  	CD_JAimeLeCreep = (new CustomItemRecord(CD_JAimeLeCreepID, "2", "J'Aime Le Creep - By Lokoise")).setUnlocalizedName("record");
	  	CD_JeMeGive = (new CustomItemRecord(CD_JeMeGiveID, "3", "Je Me Give - By Lokoise")).setUnlocalizedName("record");
	  	CD_JGeekUnMax = (new CustomItemRecord(CD_JGeekUnMaxID, "4", "J'Geek Un Max - By Lokoise")).setUnlocalizedName("record");
	  	CD_JSuisSeanKevin = (new CustomItemRecord(CD_JSuisSeanKevinID, "5", "J'Suis Sean Kevin - By Lokoise")).setUnlocalizedName("record");
	  	CD_TousLesZombies = (new CustomItemRecord(CD_TousLesZombiesID, "6", "Tous Les Zombies - By Lokoise")).setUnlocalizedName("record");
	  	CD_Acta = (new CustomItemRecord(CD_ActaID, "7", "Acta - By Lokoise")).setUnlocalizedName("record");
	  	CD_LeJournalDUnNaufragay = (new CustomItemRecord(CD_LeJournalDUnNaufragayID, "8", "Le Journal D'Un Naufragay - By Lokoise")).setUnlocalizedName("record");
	  	CD_JFaitDesPellesEnDiams = (new CustomItemRecord(CD_JFaitDesPellesEnDiamsID, "9", "J'fait des pelles en diam's - By Lokoise")).setUnlocalizedName("record");
	  	
	  	spawnLokoise = (new BlockSpawnLokoise(spawnLokoiseID, Material.rock)).setHardness(0.5F).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("oreDiamond");
		GameRegistry.registerBlock(spawnLokoise, "spawnLokoise");
		proxy.registerRenderThings();
	  	EntityRegistry.registerGlobalEntityID(EntityLokoise.class, "Lokoise", EntityRegistry.findGlobalUniqueEntityId(), 0, 0);
		EntityRegistry.registerModEntity(EntityLokoise.class, "Lokoise", 250, this, 20, 1, true);
		EntityRegistry.addSpawn(EntityLokoise.class, 1, 4, 4, EnumCreatureType.creature);
	}
	
	/** Apres initialisation du mod **/
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		/** CRAFTINGS **/
		
	      GameRegistry.addRecipe(new ItemStack(CD_BugDeChunks, 1), new Object[]
	      {"XYX", "Y Y", "XYX", 
	    	  Character.valueOf('Y'), Item.ingotGold, 
	    	  Character.valueOf('X'), Item.flint});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_JAimeLeCreep, 1), new Object[]
	      {"XZX", "Y Y", "XZX", 
	    	  Character.valueOf('Z'), Item.gunpowder, 
	    	  Character.valueOf('Y'), (new ItemStack(Item.dyePowder, 1, 2)), 
	    	  Character.valueOf('X'), Item.flint});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_JeMeGive, 1), new Object[]
	      {"XZX", "Y Y", "XZX", 
  	      Character.valueOf('Z'), Item.emerald, 
  	      Character.valueOf('Y'), (new ItemStack(Item.dyePowder, 1, 1)), 
  	      Character.valueOf('X'), Item.flint});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_JGeekUnMax, 1), new Object[]
	      {"XYX", "Y Y", "XYX", 
	    	  Character.valueOf('Y'), (new ItemStack(Item.dyePowder, 1, 1)), 
	    	  Character.valueOf('X'), Item.flint});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_JSuisSeanKevin, 1), new Object[]
	      {"XZX", "Y Y", "XZX", 
	    	  Character.valueOf('Z'), Block.dirt, 
	    	  Character.valueOf('Y'), (new ItemStack(Item.dyePowder, 1, 10)), 
	    	  Character.valueOf('X'), Item.flint});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_TousLesZombies, 1), new Object[]
	      {"XZX", "Y Y", "XZX", 
	    	  Character.valueOf('Z'), Item.rottenFlesh, 
	    	  Character.valueOf('Y'), (new ItemStack(Item.dyePowder, 1, 5)), 
	    	  Character.valueOf('X'), Item.flint});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_Acta, 1), new Object[]
	      {"XYX", "Y Y", "XYX", 
	    	  Character.valueOf('Y'), Item.coal, 
	    	  Character.valueOf('X'), Item.flint});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_LeJournalDUnNaufragay, 1), new Object[]
	      {"XZX", "A B", "XCX", 
	    	  Character.valueOf('A'), Block.mushroomRed, 
	    	  Character.valueOf('B'), Block.mushroomBrown, 
	    	  Character.valueOf('C'),  Block.plantYellow, 
	    	  Character.valueOf('Z'), Block.plantRed, 
	    	  Character.valueOf('X'), Item.flint});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_JFaitDesPellesEnDiams, 1), new Object[]
	      {"XYX", "Y Y", "XYX", 
	    	  Character.valueOf('Y'), (new ItemStack(Item.dyePowder, 1, 15)), 
	    	  Character.valueOf('X'), Item.flint});
	    
	      /** NAMES **/
		LanguageRegistry.addName(spawnLokoise, "Spawner de Lokoise en masse !");
		LanguageRegistry.instance().addStringLocalization("entity.Lokoise.name", "Lokoise");
		  
	}
	
	
}
