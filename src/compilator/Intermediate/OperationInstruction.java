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
public class OperationInstruction extends AsignationInstruction {
    
    protected String idin2;
    protected String operator;
    
    public OperationInstruction(Symbol out, Symbol in, Symbol in2, String operator) throws IncompatibleTypesException {
        super(out, in);
        
        TypeSemantics.checkScalar(in2);
        TypeSemantics.checkEqual(in, in2);
        
        idin2 = in2.getName();
        this.operator = operator;
    }

    @Override
    public String getText() {
        return idout+" := "+idin+" "+operator+" "+idin2+";";
    }
    
    
}
