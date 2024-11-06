package rearth.oritech.neoforge.client;

import net.minecraft.util.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;
import rearth.oritech.OritechClient;
import rearth.oritech.init.FluidContent;
import sample.oritech.ExampleMod;

@Mod(value = ExampleMod.MOD_ID, dist = Dist.CLIENT)
public class OritechClientNeoForge {
    
    public OritechClientNeoForge(IEventBus eventBus) {
        
        eventBus.register(new EventHandler());
        
        System.out.println("Client init");
        OritechClient.initialize();
        System.out.println("Client done");
    }
    
    static class EventHandler {
        
        @SubscribeEvent
        public void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            OritechClient.registerRenderers();
        }
        
        @SubscribeEvent
        public void initializeClient(RegisterClientExtensionsEvent event) {
            
            System.out.println("client fluid registration");
            
            FluidContent.FLUID_ATTRIBUTES.forEach(attribute -> event.registerFluidType(new IClientFluidTypeExtensions() {
                @Override
                public @NotNull Identifier getStillTexture() {
                    return attribute.getSourceTexture();
                }
                
                @Override
                public @NotNull Identifier getFlowingTexture() {
                    return attribute.getFlowingTexture();
                }
                
                @Override
                public int getTintColor() {
                    return attribute.getColor();
                }
            }, attribute.getSourceFluid().getFluidType()));
            
            System.out.println("client fluid registration done");
            
        }
        
    }
    
}
