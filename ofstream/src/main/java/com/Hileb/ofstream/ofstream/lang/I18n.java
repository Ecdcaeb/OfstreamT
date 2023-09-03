package com.Hileb.ofstream.ofstream.lang;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.Locale;

public class I18n {
    private final Locale i18nLocale;
    public final String type;
    public I18n(String currentLanguage){
        i18nLocale=new Locale();
        i18nLocale.loadLocaleDataFiles(Minecraft.getMinecraft().getResourceManager(), Lists.newArrayList(currentLanguage));
        type=currentLanguage;
    }

    /**
     * Translates the given string and then formats it. Equivilant to String.format(translate(key), parameters).
     */
    public String format(String translateKey, Object... parameters)
    {
        return i18nLocale.formatMessage(translateKey, parameters);
    }

    public boolean hasKey(String key)
    {
        String s1=i18nLocale.formatMessage(key,new Object[0]);
        return s1!=null && s1.equals(key);
    }
}
