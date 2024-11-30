package net.tropicbliss.wasmexample;

import net.fabricmc.api.ModInitializer;

import net.tropicbliss.wasmexample.command.FabricToWasmCommand;
import net.tropicbliss.wasmexample.utils.ResourceReader;
import net.tropicbliss.wasmexample.utils.WasmRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WASMExample implements ModInitializer {
	public static final String MOD_ID = "wasm-example";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static WasmRunner wasmRunner;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		FabricToWasmCommand.register();
		byte[] binary = ResourceReader.loadModResource(MOD_ID, "rustbinding.wasm");
		wasmRunner = new WasmRunner(binary);
        LOGGER.info("Hello Fabric world!");
	}
}