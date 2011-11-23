/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Intermediate;

import compilator.Symbol.*;

/**
 *
 * @author gmaiztegi
 */
public class ProgInstruction implements Instruction {
    
    protected String name;
    
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
