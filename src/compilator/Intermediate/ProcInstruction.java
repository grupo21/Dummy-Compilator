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
public class ProcInstruction implements Instruction {
    
    protected String name;
    
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
