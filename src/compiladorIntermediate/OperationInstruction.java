/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorIntermediate;

import compilator.Symbol.Symbol;

/**
 *
 * @author gmaiztegi
 */
public class OperationInstruction extends AsignationInstruction {
    
    protected String idin2;
    protected String operator;
    
    public OperationInstruction(Symbol out, Symbol in, Symbol in2, String operator) {
        super(out, in);
        
        if (!in2.isType(Symbol.INTEGER) && !in2.isType(Symbol.FLOAT)) {
            throw new IllegalArgumentException();
        }
        
        idin2 = in2.getName();
        this.operator = operator;
    }

    @Override
    public String getText() {
        return idout+" := "+idin+" "+operator+" "+idin2+";";
    }
    
    
}
