package com.Hileb.ofstream;

import com.Hileb.ofstream.ofstream.FileManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class KeyHandler {
    public static KeyBinding key;
    public KeyHandler(){
        key=new KeyBinding("ofstream", Keyboard.KEY_O,"ofstream");
        ClientRegistry.registerKeyBinding(key);
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onKeyDown(InputEvent.KeyInputEvent event){
        if (key.isPressed()){
            FileManager.ofstream();
        }
    }
}
