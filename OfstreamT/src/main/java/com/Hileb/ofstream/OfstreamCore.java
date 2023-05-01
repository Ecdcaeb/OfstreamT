package com.Hileb.ofstream;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



// The value here should match an entry in the META-INF/mods.toml file


@Mod(OfstreamCore.MODID)
public class OfstreamCore {
    public static final String MODID="ofstream_t";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public OfstreamCore() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    }


    public void doClientStuff(final FMLClientSetupEvent event) {
        new KeyHandler();
    }
}
