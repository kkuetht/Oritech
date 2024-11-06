package rearth.oritech.fabric;

import earth.terrarium.common_storage_lib.CommonStorageLib;
import net.fabricmc.api.ModInitializer;
import rearth.oritech.Oritech;
import sample.oritech.ExampleMod;

public final class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        
        // this shouldn't be needed, yet here we are
        CommonStorageLib.init();

        // Run our common setup.
        ExampleMod.init();
        Oritech.runAllRegistries();
        Oritech.initialize();
    }
}
