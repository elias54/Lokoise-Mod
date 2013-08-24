package LokoiseMod.common;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LokoiseMod_SoundEvent 
{
	@SideOnly(Side.CLIENT)
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try 
        {
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoisew1.ogg");
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoisew2.ogg");
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoisew3.ogg");
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoisew4.ogg");
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoisew5.ogg");
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoisew6.ogg");
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoised1.ogg");
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoised2.ogg");
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoiseh1.ogg");
        	event.manager.soundPoolSounds.addSound("thelokoisemod:lokoiseh2.ogg");
        	
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:Acta.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:BugDeChunk.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:J'AimeLeCreep.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:JeMeGive.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:J'faitDesPellesEnDiam's.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:J'GeekUnMax.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:J'SuisSeanKevin.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:LeJournalD'UnNaufragay.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:TousLesZombies.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:UnBanquetPresqueParfait.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:MusiqueBonusMinefight.ogg");
        	event.manager.soundPoolStreaming.addSound("thelokoisemod:UnDebitToutPourri.ogg");
        }
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}
