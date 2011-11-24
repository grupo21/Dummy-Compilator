package compiler.intermediate;

import compiler.symbol.*;

/**
 * Instrucción marca el principio del programa.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class ProgInstruction implements Instruction {
    
    protected String name;
    
    /**
     * Construye la instrucción de declaración del programa principal.
     * @param symbol El símbolo referente al nombre del programa.
     * @throws IncompatibleTypesException si el símbolo no es un programa.
     */
    public ProgInstruction(Symbol symbol) throws IncompatibleTypesException {
        TypeSemantics.checkType(symbol, Symbol.PROGRAM);
        this.name = symbol.getName();
    }

    @Override
    public String getText() {
        return "prog "+name+";";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
