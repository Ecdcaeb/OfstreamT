package com.Hileb.ofstream;

import com.Hileb.ofstream.proxy.ClientProxy;
import com.Hileb.ofstream.proxy.ProxyBase;
import com.Hileb.ofstream.proxy.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(modid = OfstreamCore.MODID, name = OfstreamCore.NAME, version = OfstreamCore.VERSION)
public class OfstreamCore {
    public static final String MODID = "ofstream_t";
    public static final String NAME = "Ofstream T";
    public static final String VERSION = "1.0.0.0";

    public static Logger logger;

    public static final boolean SHOW_WARN = true;

    @Mod.Instance
    public static OfstreamCore instance;

    @SidedProxy(clientSide = ClientProxy.PROXY, serverSide = ServerProxy.PROXY)
    public static ProxyBase proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        if(!proxy.isServer()){
            new KeyHandler();
        }
    }
    public static void LogWarning(String str, Object... args) {
        if (SHOW_WARN) {
            logger.warn(String.format(str, args));
        }
    }

    public static void LogWarning(String str) {
        if (SHOW_WARN) {
            logger.warn(str);
        }
    }

    public static void Log(String str) {
        logger.info(str);
    }

    public static void Log(String str, Object... args) {
        logger.info(String.format(str, args));
    }
}