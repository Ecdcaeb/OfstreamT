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

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;

import java.io.File;

/**
 * Created by Jerrell Fang on 2/23/2015.
 *
 * @author Meow J
 */
public class Renderer {



    public static void renderItem(ItemStack itemStack, FBOHelper fbo, String filenameSuffix, RenderItem itemRenderer) {
        Minecraft minecraft = FMLClientHandler.instance().getClient();
        float scale = 1.0F;
        fbo.begin();

        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, 16.0D, 0.0D, 16.0D, -150.0D, 150.0D);

        GL11.glMatrixMode(5888);
        RenderHelper.enableGUIStandardItemLighting();

        GL11.glTranslatef(8.0F * (1.0F - scale), 8.0F * (1.0F - scale), 0.0F);
        GL11.glScalef(scale, scale, scale);

        RenderBlocks renderBlocks = (RenderBlocks) ReflectionHelper.getPrivateValue(Render.class, itemRenderer, new String[] { "field_147909_c", "renderBlocks" });
        if (!ForgeHooksClient.renderInventoryItem(renderBlocks, minecraft.renderEngine, itemStack, true, 0.0F, 0.0F, 0.0F)) {
            itemRenderer.renderItemIntoGUI(null, minecraft.renderEngine, itemStack, 0, 0);
        }
        GL11.glMatrixMode(5889);
        RenderHelper.disableStandardItemLighting();
        GL11.glPopMatrix();

        fbo.end();
        fbo.saveToFile(new File(minecraft.mcDataDir, String.format("rendered"+File.separator+"item_%s_%d%s.png", itemStack.getItem().getUnlocalizedName().replaceAll("[^A-Za-z0-9()\\[\\]]", ""), Integer.valueOf(itemStack.getItemDamageForDisplay()), filenameSuffix)));
        fbo.restoreTexture();
    }

    public static String getItemBase64(ItemStack itemStack, FBOHelper fbo, RenderItem itemRenderer) {
        Minecraft minecraft = FMLClientHandler.instance().getClient();

        float scale =1.0F;
        fbo.begin();

        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, 16.0D, 0.0D, 16.0D, -150.0D, 150.0D);

        GL11.glMatrixMode(5888);
        RenderHelper.enableGUIStandardItemLighting();

        GL11.glTranslatef(8.0F * (1.0F - scale), 8.0F * (1.0F - scale), 0.0F);
        GL11.glScalef(scale, scale, scale);

        RenderBlocks renderBlocks = (RenderBlocks)ReflectionHelper.getPrivateValue(Render.class, itemRenderer, new String[] { "field_147909_c", "renderBlocks" });
        if (!ForgeHooksClient.renderInventoryItem(renderBlocks, minecraft.renderEngine, itemStack, true, 0.0F, 0.0F, 0.0F)) {
            itemRenderer.renderItemIntoGUI(null, minecraft.renderEngine, itemStack, 0, 0);
        }
        GL11.glMatrixMode(5889);
        RenderHelper.disableStandardItemLighting();
        GL11.glPopMatrix();

        fbo.end();
        String base64 = fbo.getBase64();
        fbo.restoreTexture();
        return base64;
    }
}
