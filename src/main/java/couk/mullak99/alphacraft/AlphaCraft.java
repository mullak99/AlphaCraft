package couk.mullak99.alphacraft;

import couk.mullak99.alphacraft.common.ModBlocks;
import couk.mullak99.alphacraft.common.ModGroup;
import couk.mullak99.alphacraft.common.Registry;
import couk.mullak99.alphacraft.common.world.OreGeneration;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AlphaCraft.MOD_ID)
public class AlphaCraft {
    public static final String MOD_ID = "alphacraft";
    public static final ItemGroup ALPHA_GROUP = new ModGroup(MOD_ID);

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public AlphaCraft() {
        LOGGER.info("Hello, world!");

        Registry.Register();

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Ore Generation
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        Registry.LateRegister();
        // some preinit code
        LOGGER.info("Preinit!");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Doing client stuff!");

        RenderTypeLookup.setRenderLayer(ModBlocks.NOSTALGIA_LEAVES.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.NOSTALGIA_SAPLING.get(), RenderType.cutoutMipped());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        LOGGER.info("InterMod stuff!");
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("alphacraft", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("Loading on a server!");
    }

    public static ResourceLocation modId(String path) {
        return new ResourceLocation(AlphaCraft.MOD_ID, path);
    }

}
