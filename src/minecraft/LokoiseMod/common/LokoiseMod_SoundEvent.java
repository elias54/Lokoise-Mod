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
        	event.manager.soundPoolSounds.addSound("lokoisew1.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoisew1.ogg"));
        	event.manager.soundPoolSounds.addSound("lokoisew2.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoisew2.ogg"));
        	event.manager.soundPoolSounds.addSound("lokoisew3.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoisew3.ogg"));
        	event.manager.soundPoolSounds.addSound("lokoisew4.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoisew4.ogg"));
        	event.manager.soundPoolSounds.addSound("lokoisew5.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoisew5.ogg"));
        	event.manager.soundPoolSounds.addSound("lokoisew6.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoisew6.ogg"));
        	event.manager.soundPoolSounds.addSound("lokoised1.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoised1.ogg"));
        	event.manager.soundPoolSounds.addSound("lokoised2.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoised2.ogg"));
        	event.manager.soundPoolSounds.addSound("lokoiseh1.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoiseh1.ogg"));
        	event.manager.soundPoolSounds.addSound("lokoiseh2.ogg", Main.class.getResource("/mods/TheLokoiseMod/sounds/lokoiseh2.ogg"));
        }
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}
