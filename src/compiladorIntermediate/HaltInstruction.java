/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorIntermediate;

/**
 *
 * @author gmaiztegi
 */
public class HaltInstruction implements Instruction {

    @Override
    public String getText() {
        return "halt;";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
