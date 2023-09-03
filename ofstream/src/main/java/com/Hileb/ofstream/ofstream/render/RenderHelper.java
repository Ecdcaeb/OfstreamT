package com.Hileb.ofstream.ofstream.render;

import com.Hileb.ofstream.ofstream.irr.FBOHelper;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class RenderHelper {
    public static String getBase64(FBOHelper fbo,IRenderObject iRenderObject,Object...args) {
        Minecraft minecraft = FMLClientHandler.instance().getClient();

        float scale =1.0F;
        fbo.begin();

        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, 16.0D, 0.0D, 16.0D, -150.0D, 150.0D);

        GL11.glMatrixMode(5888);
        net.minecraft.client.renderer.RenderHelper.enableGUIStandardItemLighting();

        GL11.glTranslatef(8.0F * (1.0F - scale), 8.0F * (1.0F - scale), 0.0F);
        GL11.glScalef(scale, scale, scale);

        iRenderObject.render(args);

//        RenderBlocks renderBlocks = (RenderBlocks) ReflectionHelper.getPrivateValue(Render.class, itemRenderer, new String[] { "field_147909_c", "renderBlocks" });
//        if (!ForgeHooksClient.renderInventoryItem(renderBlocks, minecraft.renderEngine, itemStack, true, 0.0F, 0.0F, 0.0F)) {
//            itemRenderer.renderItemIntoGUI(null, minecraft.renderEngine, itemStack, 0, 0);
//        }
        GL11.glMatrixMode(5889);
        net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
        GL11.glPopMatrix();

        fbo.end();
        String base64 = fbo.getBase64();
        fbo.restoreTexture();
        return base64;
    }
}
