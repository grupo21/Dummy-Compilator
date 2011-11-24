package compilator.Intermediate;

import compilator.Symbol.*;

/**
 * Instrucción para declarar el principio de un subprograma.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class ProcInstruction implements Instruction {
    
    protected String name;
    
    /**
     * Construye la instrucción de inicio de subprograma.
     * @param symbol Símbolo del nombre del subprograma.
     * @throws IncompatibleTypesException si el símbolo del argumento no es un subprograma.
     */
    public ProcInstruction(Symbol symbol) throws IncompatibleTypesException {
        TypeSemantics.checkType(symbol, Symbol.PROCEDURE);
        
        this.name = symbol.getName();
    }

    @Override
    public String getText() {
        return "proc "+name+";";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
