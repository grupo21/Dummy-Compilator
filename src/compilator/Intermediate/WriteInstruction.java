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
public class WriteInstruction implements Instruction {

    protected Symbol var;
    
    public WriteInstruction(Symbol var) {
        if (!var.isType(Symbol.INTEGER) && !var.isType(Symbol.FLOAT)) {
            throw new IllegalArgumentException();
        }
        
        this.var = var;
    }
    
    @Override
    public String getText() {
        return "write "+var.getName()+";";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
