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
public class ArgumentDeclarationInstruction extends DeclarationInstruction {
    
    protected boolean reference;
    
    public static String getRefValText(boolean reference) {
        return reference ? "ref" : "val";
    }
    
    public ArgumentDeclarationInstruction(Symbol symbol, boolean reference) {
        super(symbol);
        
        this.reference = reference;
    }

    @Override
    public String getText() {
        return getRefValText(reference)+"_"+getTypeText(type)+" "+name+";";
    }
}
