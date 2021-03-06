package compiler.symbol;

import compiler.SemanticException;

/**
 * Señaliza que el símbolo al que se ha intentado acceder no existe en el contexto.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class UndeclaredSymbolException extends SemanticException {
    public UndeclaredSymbolException(String id, int lineNum) {
        super("Utilización de variable no declarada en contexto: "+id
                +" en la línea "+lineNum+".");
    }
}
