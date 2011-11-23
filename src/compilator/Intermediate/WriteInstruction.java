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
public class WriteInstruction implements Instruction {

    protected Symbol var;
    
    public WriteInstruction(Symbol var) throws IncompatibleTypesException {
        TypeSemantics.checkScalar(var);
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
