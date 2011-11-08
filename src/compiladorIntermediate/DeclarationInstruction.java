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
public class DeclarationInstruction implements Instruction {
    
    protected String name;
    protected int type;
    
    public static String getTypeText(int type) {
        switch (type) {
            case Symbol.INTEGER:
                return "int";
            case Symbol.FLOAT:
                return "real";
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public DeclarationInstruction(Symbol symbol) {
        if (!symbol.isType(Symbol.INTEGER) && !symbol.isType(Symbol.FLOAT)) {
            throw new IllegalArgumentException();
        }
        
        this.name = symbol.getName();
        this.type = symbol.getType();
    }

    @Override
    public String getText() {
        return getTypeText(this.type)+" "+this.name+";";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
