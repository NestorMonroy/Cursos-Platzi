package _04_functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {
    static void showHelp(CLIArguments cliArguments) {
        //Consumer: Interfaz genérica para trabajar por un tipo de dato
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            if (cliArguments1.isHelp()) {
                System.out.println("Manual solicitado");
            }
        };
        //Invocar al consumer recién generado ** Realizar operacion para este dato ejemplo borrar archivos
        consumerHelper.accept(cliArguments);
    }


    static CLIArguments generateCLI() {
        //Supplier se encarga de generar datos ** generar configuraciones bajo demanda.
        Supplier<CLIArguments> generator = () -> new CLIArguments();
        return generator.get();
    }

}
