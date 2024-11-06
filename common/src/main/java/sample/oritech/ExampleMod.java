package sample.oritech;

import io.wispforest.owo.ui.container.FlowLayout;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public final class ExampleMod {
    public static final String MOD_ID = "oritech";

    public static void init() {
        // Write common init code here.
        
        ServerLifecycleEvents.SERVER_STARTED.register(ExampleMod::test);
        
        System.out.println(FlowLayout.class);
        
    }
    
    private static void test(MinecraftServer minecraftServer) {
        System.out.println("hello world!");
    }
}
