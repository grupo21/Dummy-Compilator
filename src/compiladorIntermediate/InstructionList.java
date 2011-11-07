/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorIntermediate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gmaiztegi
 */
public class InstructionList {
    
    protected List<Instruction> instructions;
    
    public InstructionList() {
        instructions = new ArrayList<Instruction>();
    }
    
    public void add(Instruction instruction) {
        instructions.add(instruction);
    }
    
    public Instruction get(int ref) {
        return instructions.get(ref);
    }
    
    public Instruction get(Marker marker) {
        if (marker.getList() != this) {
            throw new IllegalArgumentException();
        }
        
        return get(marker.getIndex());
    }
    
    public Marker getCurrentMarker() {
        return new Marker(this, instructions.size());
    }
}
