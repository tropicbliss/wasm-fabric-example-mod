package net.tropicbliss.wasmexample.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;
import net.tropicbliss.wasmexample.bindings.Adder;

import static net.minecraft.server.command.CommandManager.*;

public class FabricToWasmCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("fabrictowasm").then(argument("value", IntegerArgumentType.integer()).executes(context -> {
            final int value = IntegerArgumentType.getInteger(context, "value");
            final int result = Adder.addTwice(value);
            context.getSource().sendFeedback(() -> Text.literal("%s + %s = %s".formatted(value, value, result)), false);
            return result;
        }))));
    }
}
