package com.Hileb.ofstream.ofstream.lang;

import net.minecraft.client.resources.Locale;

public class I18n {
    private final Locale i18nLocale;
    public final String type;
    public I18n(Locale localeIn,String typeIn){
        i18nLocale=localeIn;
        type=typeIn;
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
        return i18nLocale.hasKey(key);
    }
}
