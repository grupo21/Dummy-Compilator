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
}
