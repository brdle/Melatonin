package net.onvoid.melatonin.proxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy extends CommonProxy {

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void registerListeners(){
        super.registerListeners();
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        modBus.addListener(this::setupClient);
        modBus.addListener(this::loadComplete);
    }

    @SubscribeEvent
    public void setupClient(FMLClientSetupEvent e){
        e.enqueueWork(() ->
        {
            //
        });
        //Atlases.addWoodType(MelatoninBlocks.WOOD_NAME);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void loadComplete(FMLLoadCompleteEvent e){
        return;
    }
}