package com.Hileb.ofstream.ofstream.lang;


import net.minecraft.client.resources.Language;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import java.util.*;


@OnlyIn(Dist.CLIENT)
public class LangHelper {
    public static final Language EN_US = new Language("en_us", "US", "English", false);
    public static final Language ZH_CN = new Language("zh_cn", "中文", "简体中文", true);
    public static HashMap<String,I18n> LANGUAGES_MAP=new HashMap<>();
    public static I18n getI18n(Language currentLanguage)
    {
        if (LANGUAGES_MAP.containsKey(currentLanguage.getCode())){
            return LANGUAGES_MAP.get(currentLanguage.getCode());
        }
        else {
            return getI18nForcedReload(currentLanguage);
        }
    }
    public static I18n getI18nForcedReload(Language currentLanguage)
    {
        I18n i18n=new I18n(currentLanguage);
        if (LANGUAGES_MAP.containsKey(currentLanguage.getCode())){
            LANGUAGES_MAP.remove(currentLanguage.getCode());
        }
        LANGUAGES_MAP.put(currentLanguage.getCode(),i18n);

        return i18n;

    }

}
