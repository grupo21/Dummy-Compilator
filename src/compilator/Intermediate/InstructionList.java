/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Intermediate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gmaiztegi
 */
public class InstructionList implements Iterable {
    
    protected List<Instruction> instructions;
    
    public InstructionList() {
        instructions = new ArrayList<Instruction>();
    }
    
    public Marker add(Instruction instruction) {
        instructions.add(instruction);
        return new Marker(this, instructions.size()-1);
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

    @Override
    public Iterator<Instruction> iterator() {
        return instructions.iterator();
    }
}
