package compiler.symbol;

/**
 * Clase con métodos estáticos para comprobación de tipos.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class TypeSemantics {
    
    /**
     * Comprueba que el símbolo sea del tipo indicado.
     * @param symbol El símbolo a comprobar.
     * @param type El tipo que la variable debe ser.
     * @throws IncompatibleTypesException si la comprobación ha fallado.
     */
    public static void checkType (Symbol symbol, int type) throws IncompatibleTypesException {
        if (!symbol.isType(type)) {
            throw new IncompatibleTypesException();
        }
    }

    /**
     * Comprueba que los tipos de ambos símbolos sean iguales sean iguales / compatibles.
     * @param symbol1 El primer símbolo
     * @param symbol2 El segundo símbolo
     * @throws IncompatibleTypesException si los tipos no son iguales.
     */
    public static void checkEqual (Symbol symbol1, Symbol symbol2) throws IncompatibleTypesException {
        if (!symbol1.isType(symbol2.getType())) {
            throw new IncompatibleTypesException();
        }
    }
    
    /**
     * Comprueba que el símbolo sea escalar (integer o float).
     * @param symbol El símbolo a comprobar.
     * @throws IncompatibleTypesException si el tipo del símbolo no es escalar.
     */
    public static void checkScalar (Symbol symbol) throws IncompatibleTypesException {
        if (!symbol.isType(Symbol.INTEGER)
             && !symbol.isType(Symbol.FLOAT)) {
            throw new IncompatibleTypesException();
        }
    }
    
    /**
     * Comprueba que el símbolo es de un tipo al que se pueda llamar.
     * @param symbol El símbolo a comprobar.
     * @throws IncompatibleTypesException si al símbolo no se le puede llamar.
     */
    public static void checkCallable (Symbol symbol) throws IncompatibleTypesException {
        if (!symbol.isType(Symbol.PROCEDURE)
                && !symbol.isType(Symbol.FUNCTION)) {
            throw new IncompatibleTypesException();
        }
    }
}
