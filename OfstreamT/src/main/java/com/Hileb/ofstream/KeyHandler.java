package com.Hileb.ofstream;

import com.Hileb.ofstream.ofstream.FileManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class KeyHandler {
    public static KeyBinding key;
    public KeyHandler(){
        key=new KeyBinding("ofstream", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_O,"ofstream");
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
