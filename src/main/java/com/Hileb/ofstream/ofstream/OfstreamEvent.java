package com.Hileb.ofstream.ofstream;

import com.Hileb.ofstream.ofstream.lang.I18n;
import net.minecraftforge.fml.common.eventhandler.Event;

public abstract class OfstreamEvent extends Event {
    public OfstreamEvent(){}

    @Override
    public boolean isCancelable() {
        return false;
    }
    /*
    * 每当这个事件发生时，你都需要使用
    * @link com.Hileb.ofstream.ofstream.FileManager::register
    * */
    public static class Register extends OfstreamEvent{
        public Register(){

        }
        public void register(OfstreamRegisterObject object){
            FileManager.register(object);
        }
    }
    @Deprecated
    public static class EnUs extends OfstreamEvent{
        private final I18n i18n;
        public EnUs(I18n i18nIn){
            i18n=i18nIn;
        }

        public I18n getI18n() {
            return i18n;
        }
    }
    @Deprecated
    public static class ZhCn extends OfstreamEvent{
        private final I18n i18n;
        public ZhCn(I18n i18nIn){
            i18n=i18nIn;
        }
        public I18n getI18n() {
            return i18n;
        }
    }

}
