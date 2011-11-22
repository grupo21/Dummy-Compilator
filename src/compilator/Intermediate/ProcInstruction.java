/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Intermediate;

import compilator.Symbol.Symbol;

/**
 *
 * @author gmaiztegi
 */
public class ProcInstruction implements Instruction {
    
    protected String name;
    
    public ProcInstruction(Symbol symbol) {
        if (!symbol.isType(Symbol.PROCEDURE)) {
            throw new IllegalArgumentException();
        }
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
