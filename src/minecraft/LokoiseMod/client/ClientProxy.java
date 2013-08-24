package LokoiseMod.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.src.ModLoader;
import LokoiseMod.common.CommonProxy;
import LokoiseMod.common.EntityLokoise;
import LokoiseMod.common.Main;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityLokoise.class, new RenderLokoise(new ModelBiped(), 0.5f));
	}
	@Override
	public void registerAchievement()
	{
		ModLoader.addAchievementDesc(Main.BugDeChunks , "Bug De Chunks", "Avoir un CD musical de \"Bug De Chunks\"");
		ModLoader.addAchievementDesc(Main.JAimeLeCreep , "J'Aime Le Creep", "Avoir un CD musical de \"J'Aime Le Creep\"");
		ModLoader.addAchievementDesc(Main.JeMeGive , "Je Me Give", "Avoir un CD musical de \"Je Me Give\"");
		ModLoader.addAchievementDesc(Main.JGeekUnMax , "J'Geek Un Max", "Avoir un CD musical de \"J'Geek Un Max\"");
		ModLoader.addAchievementDesc(Main.JSuisSeanKevin , "J'Suis Sean Kevin", "Avoir un CD musical de \"J'Suis Sean Kevin\"");
		ModLoader.addAchievementDesc(Main.TousLesZombies , "Tous Les Zombies", "Avoir un CD musical de \"Tous Les Zombies\"");
		ModLoader.addAchievementDesc(Main.Acta , "Acta", "Avoir un CD musical de \"Acta\"");
		ModLoader.addAchievementDesc(Main.LeJournalDUnNaufragay , "Le Journal D'Un Naufragay", "Avoir un CD musical de \"Le Journal D'Un Naufragay\"");
		ModLoader.addAchievementDesc(Main.JFaitDesPellesEnDiams , "J'fais des pelles en diam's", "Avoir un CD musical de \"J'fais des pelles en diam's\"");
		ModLoader.addAchievementDesc(Main.UnBanquetPresqueParfait , "Un banquet presque parfait", "Avoir un CD musical de \"Un banquet presque parfait\"");
		ModLoader.addAchievementDesc(Main.MusiqueBonusMinefight , "Musique Bonus Minefight", "Avoir un CD musical de \"Musique Bonus Minefight\"");
		ModLoader.addAchievementDesc(Main.UnDebitToutPourri , "Un d\351bit tout pourri", "Avoir un CD musical de \"Un débit tout pourri\"");
	}
}
