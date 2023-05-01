/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.Hileb.ofstream.ofstream.irr;


import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.io.File;

/**
 * Created by Jerrell Fang on 2/23/2015.
 *
 * @author Meow J
 */
public class Renderer {



    public static void renderItem(ItemStack itemStack, FBOHelper fbo, String filenameSuffix, ItemRenderer itemRenderer) {
        Minecraft minecraft =Minecraft.getInstance();
        float scale = 1.0F;
        fbo.begin();

        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0, 16, 0, 16, -150.0F, 150.0F);

        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        GlStateManager.enableLighting();

        GlStateManager.translated(8 * (1 - scale), 8 * (1 - scale), 0);
        GlStateManager.scaled(scale, scale, scale);

        itemRenderer.renderItemIntoGUI(itemStack, 0, 0);

        GlStateManager.disableLighting();
        RenderHelper.disableStandardItemLighting();

        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GL11.glPopMatrix();

        fbo.end();
        fbo.saveToFile(new File(minecraft.gameDir, String.format("rendered"+File.separator+"item_%s_%d%s.png", itemStack.getItem().getTranslationKey().replaceAll("[^A-Za-z0-9()\\[\\]]", ""), itemStack.getDamage(), filenameSuffix)));
        fbo.restoreTexture();
    }

    public static String getItemBase64(ItemStack itemStack, FBOHelper fbo, ItemRenderer itemRenderer) {
        String base64;
        float scale = 1.0F;
        fbo.begin();

        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0, 16, 0, 16, -150.0F, 150.0F);

        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        GlStateManager.enableLighting();

        GlStateManager.translated(8 * (1 - scale), 8 * (1 - scale), 0);
        GlStateManager.scaled(scale, scale, scale);

        itemRenderer.renderItemIntoGUI(itemStack, 0, 0);

        GlStateManager.disableLighting();
        RenderHelper.disableStandardItemLighting();

        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GL11.glPopMatrix();

        fbo.end();
        base64 = fbo.getBase64();
        fbo.restoreTexture();
        return base64;
    }
}
