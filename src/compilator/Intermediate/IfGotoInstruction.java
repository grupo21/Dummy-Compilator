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
public class IfGotoInstruction extends GotoInstruction {
    
    protected Symbol x, y;
    protected String operation;
    
    public IfGotoInstruction(Symbol x, Symbol y, String operation, Marker where) {
        super(where);
        this.x = x;
        this.y = y;
        this.operation = operation;
    }
    
    public IfGotoInstruction(Symbol x, Symbol y, String operation) {
        super();
        this.x = x;
        this.y = y;
        this.operation = operation;
    }
    
    @Override
    public String getText() {
        return "if "+x.getName()+" "+operation+" "+y.toString()+" "+super.getText();
    }
}
