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
public class AsignationInstruction implements Instruction {
    
    protected String idout, idin;

    public AsignationInstruction(Symbol out, Symbol in) {
        if (!out.isType(Symbol.INTEGER) && !out.isType(Symbol.FLOAT)
                || !in.isType(Symbol.INTEGER) && !in.isType(Symbol.FLOAT)) {
            throw new IllegalArgumentException();
        }
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
