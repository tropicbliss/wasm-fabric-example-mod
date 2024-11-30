package net.tropicbliss.wasmexample.utils;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceReader {
    public static byte[] loadModResource(String modId, String path) {
        try {
            return FabricLoader.getInstance()
                    .getModContainer(modId)
                    .orElseThrow(() -> new RuntimeException("Mod " + modId + " not found")).findPath(path)
                    .map(ResourceReader::readPath)
                    .orElseThrow(() -> new RuntimeException("Resource " + path + " not found"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load resource: " + path, e);
        }
    }

    private static byte[] readPath(Path path) {
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + path, e);
        }
    }
}
