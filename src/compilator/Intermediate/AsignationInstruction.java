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
public class AsignationInstruction implements Instruction {
    
    protected String idout, idin;

    public AsignationInstruction(Symbol out, Symbol in) throws IncompatibleTypesException {
        
        TypeSemantics.checkScalar(out);
        TypeSemantics.checkScalar(in);
        TypeSemantics.checkEqual(in, out);
        
        this.idout = out.getName();
        this.idin = in.getName();
    }
    
    @Override
    public String getText() {
        return idout+" := "+idin+";";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
