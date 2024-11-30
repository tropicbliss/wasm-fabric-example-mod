package net.tropicbliss.wasmexample.utils;

import io.github.kawamuray.wasmtime.*;
import io.github.kawamuray.wasmtime.Module;

import java.util.Collections;

public class WasmRunner implements AutoCloseable {
    private final Store<Void> store;
    private final Module module;
    private final Instance instance;

    public WasmRunner(byte[] binary) {
        store = Store.withoutData();
        module = Module.fromBinary(store.engine(), binary);
        instance = new Instance(store, module, Collections.emptyList());
    }

    /// Remember to close the function after use
    public Func getFunction(String functionName) {
        return instance.getFunc(store, functionName).get();
    }

    public Store<Void> getStore() {
        return store;
    }

    @Override
    public void close() {
        instance.close();
        module.close();
        store.close();
    }
}
