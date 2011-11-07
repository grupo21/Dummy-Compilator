/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorIntermediate;

/**
 *
 * @author gmaiztegi
 */
public class Marker {
    
    protected int reference;
    protected InstructionList list;
    
    Marker(InstructionList list, int reference) {
        this.list = list;
        this.reference = reference;
    }
}
