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
        	event.manager.soundPoolMusic.addSound("", Main.class.getResource(""));
        }
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}
