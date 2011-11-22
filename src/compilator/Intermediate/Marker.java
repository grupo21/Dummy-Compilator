/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Intermediate;

/**
 *
 * @author gmaiztegi
 */
public class Marker {
    
    protected int index;
    protected InstructionList list;
    
    Marker(InstructionList list, int idx) {
        this.list = list;
        this.index = idx;
    }
    
    public int getIndex() {
        return index;
    }
    
    public Marker add(int i) {
        index += i;
        return this;
    }
    
    public InstructionList getList() {
        return list;
    }
    
    public Instruction getInstruction() {
        return list.get(index);
    }
}
