package com.Hileb.ofstream;

import com.Hileb.ofstream.ofstream.FileManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = OfstreamCore.MODID)
public class KeyHandler {
    public static KeyBinding key;
    public KeyHandler(){
        key=new KeyBinding("ofstream", Keyboard.KEY_O,"ofstream");
        ClientRegistry.registerKeyBinding(key);
    }
    @SubscribeEvent
    public static void onKeyDown(InputEvent.KeyInputEvent event){
        if (key.isPressed()){
            FileManager.ofstream();
        }
    }
}
