package com.Hileb.ofstream;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(modid = OfstreamCore.MODID, name = OfstreamCore.NAME, version = OfstreamCore.VERSION)
public class OfstreamCore {
    public static final String MODID = "ofstream_t";
    public static final String NAME = "Ofstream T";
    public static final String VERSION = "1.0.0.2";

    public static Logger logger;


    @Mod.Instance
    public static OfstreamCore instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        new KeyHandler();
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
    }
}