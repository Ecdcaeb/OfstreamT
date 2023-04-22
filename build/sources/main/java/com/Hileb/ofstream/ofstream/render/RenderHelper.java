package com.Hileb.ofstream.ofstream.render;

import com.Hileb.ofstream.ofstream.irr.FBOHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class RenderHelper {
    public static String getBase64(FBOHelper fboHelper,IRenderObject iRenderObject,Object...args) {
        String base64;
        float scale = 1.0F;
        fboHelper.begin();

        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0, 16, 0, 16, -150.0F, 150.0F);

        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        net.minecraft.client.renderer.RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        GlStateManager.enableLighting();

        GlStateManager.translate(8 * (1 - scale), 8 * (1 - scale), 0);
        GlStateManager.scale(scale, scale, scale);

        iRenderObject.render(args);

        GlStateManager.disableLighting();
        net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();

        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GL11.glPopMatrix();

        fboHelper.end();
        base64 = fboHelper.getBase64();
        fboHelper.restoreTexture();
        return base64;
    }
}
