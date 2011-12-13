package compiler.symbol;

import compiler.SemanticException;

/**
 * Señaliza el intento de redefinir una variable del mismo nombre y contexto.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class RedefinedSymbolException extends SemanticException {
    public RedefinedSymbolException (String id, int definedLine, int redefinitionLine) {
        super("Se ha intentado declarar otra vez la variable "+id+"en la línea "
                +redefinitionLine+", previamente declarada en la línea "
                +definedLine+".");
    }
}
