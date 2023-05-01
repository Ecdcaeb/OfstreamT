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

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;


/**
 * Created by Meow J on 8/17/2015.
 *
 * @author Meow J
 */
public class ExportUtils {
	private Thread item,entity;
    public static final ExportUtils INSTANCE=new ExportUtils();
    public int progress=1,size;
    public  int progress1=1,size1;
    public final FBOHelper fboSmall;
    public final FBOHelper fboLarge;
    public final FBOHelper fboEntity;
    public final ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

    
    public ExportUtils() {
        // Hardcoded value for mcmod.cn only, don't change this unless the website updates
        fboSmall = new FBOHelper(32);
        fboLarge = new FBOHelper(128);
        fboEntity = new FBOHelper(200);
    }
    public String getSmallIcon(ItemStack itemStack) {
        return Renderer.getItemBase64(itemStack, fboSmall, itemRenderer);
    }

    public String getLargeIcon(ItemStack itemStack) {
        return Renderer.getItemBase64(itemStack, fboLarge, itemRenderer);
    }
}
