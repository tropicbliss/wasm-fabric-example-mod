package net.tropicbliss.wasmexample.bindings;

import io.github.kawamuray.wasmtime.Func;
import io.github.kawamuray.wasmtime.WasmFunctions;
import io.github.kawamuray.wasmtime.WasmValType;
import net.tropicbliss.wasmexample.WASMExample;
import net.tropicbliss.wasmexample.utils.WasmRunner;

public class Adder {
    public static int addTwice(int value) {
        WasmRunner wasmRunner = WASMExample.wasmRunner;
        try (Func fun = wasmRunner.getFunction("add")) {
            WasmFunctions.Function2<Integer, Integer, Integer> add = WasmFunctions.func(wasmRunner.getStore(), fun,  WasmValType.I32, WasmValType.I32, WasmValType.I32);
            return add.call(value, value);
        }
    }
}
