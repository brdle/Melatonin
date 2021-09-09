package net.onvoid.melatonin.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.onvoid.melatonin.Melatonin;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Melatonin.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    public void start() {
        //MelatoninBlocks.create();
        //MelatoninTiles.create();
        //MelatoninItems.create();
        //TagHandler.init();
        registerListeners();
    }

    public void registerListeners(){
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        modBus.addListener(this::setup);
        //forgeBus.register(new EventHandler());
        //forgeBus.register(new WorldGenHandler());
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent e){
        e.enqueueWork(() ->
        {
            //WoodType.register(MelatoninBlocks.WOOD_NAME);
        });
    }
}