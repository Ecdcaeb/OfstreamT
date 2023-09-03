package com.Hileb.ofstream.ofstream.lang;



import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.*;


@SideOnly(Side.CLIENT)
public class LangHelper {
    public static final String ZH_CN="zh_cn";
    public static final String EN_US="en_us";
    public static HashMap<String,I18n> LANGUAGES_MAP=new HashMap<String,I18n>();
    public static I18n getI18n(String currentLanguage)
    {
        if (LANGUAGES_MAP.containsKey(currentLanguage)){
            return LANGUAGES_MAP.get(currentLanguage);
        }
        else {
            return getI18nForcedReload(currentLanguage);
        }
    }
    public static I18n getI18nForcedReload(String currentLanguage)
    {
        I18n i18n=new I18n(currentLanguage);
        if (LANGUAGES_MAP.containsKey(currentLanguage)){
            LANGUAGES_MAP.remove(currentLanguage);
        }
        LANGUAGES_MAP.put(currentLanguage,i18n);

        return i18n;

    }

}
