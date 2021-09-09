package net.onvoid.melatonin;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.onvoid.melatonin.proxy.ClientProxy;
import net.onvoid.melatonin.proxy.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("melatonin")
public class Melatonin
{
    public static final String MODID = "adjunct";
    public static Melatonin instance;
    public static CommonProxy proxy;
    private static final Logger LOGGER = LogManager.getLogger();

    public Melatonin() {
        instance = this;

        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        proxy.start();
    }

    /*private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("adjunct", "init", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }*/
}
