package com.Hileb.ofstream.ofstream.lang;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ClientLanguageMap;
import net.minecraft.client.resources.Language;

import java.util.IllegalFormatException;

public class I18n {

    private final ClientLanguageMap i18nLocale;
    public final String type;
    public I18n(Language currentLanguage){
        i18nLocale=ClientLanguageMap.func_239497_a_(Minecraft.getInstance().getResourceManager(),Lists.newArrayList(currentLanguage));
        type=currentLanguage.getCode();
    }

    /**
     * Translates the given string and then formats it. Equivilant to String.format(translate(key), parameters).
     */
    public String format(String translateKey, Object... parameters)
    {
        String s = i18nLocale.func_230503_a_(translateKey);

        try {
            return String.format(s, parameters);
        } catch (IllegalFormatException var4) {
            return "Format error: " + s;
        }
    }

    public boolean hasKey(String key)
    {
        return i18nLocale.func_230506_b_(key);
    }
}
