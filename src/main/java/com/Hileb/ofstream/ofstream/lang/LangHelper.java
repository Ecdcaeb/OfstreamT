package com.Hileb.ofstream.ofstream.lang;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.*;
import net.minecraft.client.resources.Locale;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.LanguageMap;
import net.minecraftforge.client.resource.VanillaResourceType;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;


@SideOnly(Side.CLIENT)
public class LangHelper {
    public static I18n getI18n(String currentLanguage)
    {
        Locale locale=new Locale();
        locale.loadLocaleDataFiles( Minecraft.getMinecraft().getResourceManager(), Lists.newArrayList(currentLanguage));

        return new I18n(locale,currentLanguage);
    }
}
