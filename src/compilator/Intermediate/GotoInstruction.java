/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Intermediate;

/**
 *
 * @author gmaiztegi
 */
public class GotoInstruction implements Instruction, CompletableInstruction {
    
    protected Marker where;
    
    public GotoInstruction() {
        where = null;
    }
    
    public GotoInstruction(Marker where) {
        this.where = where;
    }
    
    @Override
    public String getText() {
        String idx = where != null ? String.valueOf(where.index) : "__";
        return "goto "+idx+";";
    }

    @Override
    public boolean isComplete() {
        return where != null;
    }

    @Override
    public void complete(Marker marker) {
        where = marker;
    }
    
}
