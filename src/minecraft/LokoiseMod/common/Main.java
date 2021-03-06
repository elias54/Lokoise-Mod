package LokoiseMod.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.MODVERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Main 
{
	
	public static final String MODID = "thelokoisemod";
	public static final String MODNAME = "Lokoise Mod";
	public static final String MODVERSION = "v2";
	
	@SidedProxy(clientSide = "LokoiseMod.client.ClientProxy", serverSide = "LokoiseMod.common.CommonProxy", modId = MODID)

	public static CommonProxy proxy;
	
	@Instance(MODID)
	public static Main instance;
	
	public static int getFreeEggID;
	
	public static Item CD_BugDeChunks,
				  	   CD_JAimeLeCreep,
				  	   CD_JeMeGive,
				  	   CD_JGeekUnMax,
				  	   CD_JSuisSeanKevin,
				  	   CD_TousLesZombies, 
				  	   CD_Acta,
				  	   CD_LeJournalDUnNaufragay,
				  	   CD_JFaitDesPellesEnDiams,
				  	   CD_MusiqueBonusMinefight,
				  	   CD_UnBanquetPresqueParfait,
				  	   CD_UnDebitToutPourri;
	
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
	   		   CD_MusiqueBonusMinefightID,
	   		   CD_UnBanquetPresqueParfaitID,
	   		   CD_UnDebitToutPourriID,
	   		   spawnLokoiseID;
	static int ia = 9000;

    public static Achievement BugDeChunks,
    						  JAimeLeCreep,
    						  JeMeGive,
    						  JGeekUnMax,
    						  JSuisSeanKevin,
    						  TousLesZombies,
    						  Acta,
    						  LeJournalDUnNaufragay,
    						  JFaitDesPellesEnDiams,
    						  MusiqueBonusMinefight,
    						  UnBanquetPresqueParfait,
    						  UnDebitToutPourri;

	public Main()
	{
		getFreeEggID = EntityRegistry.findGlobalUniqueEntityId();
	}
	
	/** Pre initialisation du mod **/
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new LokoiseMod_SoundEvent());
		try 
		{
			config.load();
			CD_BugDeChunksID = config.getItem("CD Bug de chunk ID", 5000).getInt();
			CD_JAimeLeCreepID =  config.getItem("CD J'aime le creep ID", 5001).getInt();
			CD_JeMeGiveID =  config.getItem("CD Je me give ID", 5002).getInt();
			CD_JGeekUnMaxID =  config.getItem("CD J'geek un max ID", 5003).getInt();
			CD_JSuisSeanKevinID =  config.getItem("CD J'suis Sean Kevin ID", 5004).getInt();
			CD_TousLesZombiesID =  config.getItem("CD Tous les zombies ID", 5005).getInt();
			CD_ActaID =  config.getItem("CD Acta ID", 5006).getInt();
			CD_LeJournalDUnNaufragayID =  config.getItem("CD Le journal d'un Naufragay ID", 5007).getInt();
			CD_JFaitDesPellesEnDiamsID =  config.getItem("CD J'fais des pelles en diams ID", 5008).getInt();
			CD_UnBanquetPresqueParfaitID = config.getItem("CD Un banquet presque parfait", 5009).getInt();
			CD_MusiqueBonusMinefightID = config.getItem("CD Musique Bonus Minefight", 5010).getInt();
			CD_UnDebitToutPourriID = config.getItem("CD Un d�bit tout pourri", 5011).getInt();
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
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		
	  	EntityRegistry.registerGlobalEntityID(EntityLokoise.class, "Lokoise", getFreeEggID, 0xE6ED0E, 0x1B8600);
		EntityRegistry.registerModEntity(EntityLokoise.class, "Lokoise", 250, this, 40, 1, true);
		EntityRegistry.addSpawn(EntityLokoise.class, 1, 4, 4, EnumCreatureType.creature);
		
		CD_BugDeChunks = (new CustomItemRecord(CD_BugDeChunksID, "thelokoisemod:BugDeChunk", "13")).setUnlocalizedName("record");
	  	CD_JAimeLeCreep = (new CustomItemRecord(CD_JAimeLeCreepID, "thelokoisemod:J'AimeLeCreep", "blocks")).setUnlocalizedName("record");
	  	CD_JeMeGive = (new CustomItemRecord(CD_JeMeGiveID, "thelokoisemod:JeMeGive", "cat")).setUnlocalizedName("record");
	  	CD_JGeekUnMax = (new CustomItemRecord(CD_JGeekUnMaxID, "thelokoisemod:J'GeekUnMax", "chirp")).setUnlocalizedName("record");
	  	CD_JSuisSeanKevin = (new CustomItemRecord(CD_JSuisSeanKevinID, "thelokoisemod:J'SuisSeanKevin", "far")).setUnlocalizedName("record");
	  	CD_TousLesZombies = (new CustomItemRecord(CD_TousLesZombiesID, "thelokoisemod:TousLesZombies", "mall")).setUnlocalizedName("record");
	  	CD_Acta = (new CustomItemRecord(CD_ActaID, "thelokoisemod:Acta", "mellohi")).setUnlocalizedName("record");
	  	CD_LeJournalDUnNaufragay = (new CustomItemRecord(CD_LeJournalDUnNaufragayID, "thelokoisemod:LeJournalD'UnNaufragay", "stal")).setUnlocalizedName("record");
	  	CD_JFaitDesPellesEnDiams = (new CustomItemRecord(CD_JFaitDesPellesEnDiamsID, "thelokoisemod:J'faitDesPellesEnDiam's", "strad")).setUnlocalizedName("record");
	  	CD_UnBanquetPresqueParfait = (new CustomItemRecord(CD_UnBanquetPresqueParfaitID, "thelokoisemod:UnBanquetPresqueParfait", "13")).setUnlocalizedName("record");
	  	CD_MusiqueBonusMinefight = (new CustomItemRecord(CD_MusiqueBonusMinefightID, "thelokoisemod:MusiqueBonusMinefight", "blocks")).setUnlocalizedName("record");
	  	CD_UnDebitToutPourri = (new CustomItemRecord(CD_UnDebitToutPourriID, "thelokoisemod:UnDebitToutPourri", "blocks")).setUnlocalizedName("record");
	  	spawnLokoise = new BlockSpawnLokoise(spawnLokoiseID, Material.rock).setHardness(0.5F).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("lokoiseSpawn");
		GameRegistry.registerBlock(spawnLokoise, "spawnLokoise");
		GameRegistry.registerWorldGenerator(new BlockGeneration());
		BugDeChunks = new Achievement(ia++, "BugDeChunk", -10, 2, CD_BugDeChunks, null).registerAchievement();
		JAimeLeCreep = new Achievement(ia++, "JAimeLeCreep", -11, 2, CD_JAimeLeCreep, null).registerAchievement();
		JeMeGive = new Achievement(ia++, "JeMeGive", -12, 2, CD_JeMeGive, null).registerAchievement();
		JGeekUnMax = new Achievement(ia++, "JGeekUnMax", -13, 4, CD_JGeekUnMax, null).registerAchievement();
		JSuisSeanKevin = new Achievement(ia++, "JSuisSeanKevin", -10, 3, CD_JSuisSeanKevin, null).registerAchievement();
		TousLesZombies = new Achievement(ia++, "TousLesZombies", -11, 3, CD_TousLesZombies, null).registerAchievement();
		Acta = new Achievement(ia++, "Acta", -12, 3, CD_Acta, null).registerAchievement();
		LeJournalDUnNaufragay = new Achievement(ia++, "Le Journal D'Un Naufragay", -13, 2, CD_LeJournalDUnNaufragay, null).registerAchievement();
		JFaitDesPellesEnDiams = new Achievement(ia++, "J'fait des pelles en diam's", -13, 3, CD_JFaitDesPellesEnDiams, null).registerAchievement();
		UnBanquetPresqueParfait = new Achievement(ia++, "Un banquet presque parfait", -12, 4, CD_UnBanquetPresqueParfait, null).registerAchievement();
		MusiqueBonusMinefight = new Achievement(ia++, "Musique Bonus Minefight", -11, 4, CD_MusiqueBonusMinefight, null).registerAchievement();
		UnDebitToutPourri = new Achievement(ia++, "UnDebitToutPourri", -10 , 4, CD_UnDebitToutPourri, null).registerAchievement();
		GameRegistry.registerCraftingHandler(new LokoiseModCraftingHandler());
	  	GameRegistry.registerPickupHandler(new LokoiseModItemPickupHandler());
		proxy.registerRenderThings();
	}
	
	/** Apres initialisation du mod **/
	@Mod.EventHandler
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
	      
	      GameRegistry.addRecipe(new ItemStack(CD_UnBanquetPresqueParfait, 1), new Object[]
	      {"XXX", "XXX", "XXX", 
	    	  Character.valueOf('X'), (new ItemStack(Block.dirt))});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_MusiqueBonusMinefight, 1), new Object[]
	      {"XXX", "XXX", "XXX", 
	    	  Character.valueOf('X'), (new ItemStack(Block.stone))});
	      
	      GameRegistry.addRecipe(new ItemStack(CD_UnDebitToutPourri, 1), new Object[]
	      {"XXX", "XXX", "XXX",
	    	  Character.valueOf('X'), (new ItemStack(Block.stone))});
	    
	      /** NAMES **/
		LanguageRegistry.addName(spawnLokoise, "Spawner de Lokoise en masse !");
		LanguageRegistry.instance().addStringLocalization("entity.Lokoise.name", "Lokoise");
		proxy.registerAchievement();
	}
	

	
	
}
