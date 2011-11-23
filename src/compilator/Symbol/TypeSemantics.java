/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Symbol;

/**
 *
 * @author gmaiztegi
 */
public class TypeSemantics {
    
    public static void checkType (Symbol symbol, int type) throws IncompatibleTypesException {
        if (!symbol.isType(type)) {
            throw new IncompatibleTypesException();
        }
    }
    
    public static void checkEqual (Symbol symbol1, Symbol symbol2) throws IncompatibleTypesException {
        if (!symbol1.isType(symbol2.getType())) {
            throw new IncompatibleTypesException();
        }
    }
    
    public static void checkScalar (Symbol symbol) throws IncompatibleTypesException {
        if (!symbol.isType(Symbol.INTEGER)
             && !symbol.isType(Symbol.FLOAT)) {
            throw new IncompatibleTypesException();
        }
    }
    
    public static void checkCallable (Symbol symbol) throws IncompatibleTypesException {
        if (!symbol.isType(Symbol.PROCEDURE)
                && !symbol.isType(Symbol.FUNCTION)) {
            throw new IncompatibleTypesException();
        }
    }
}
