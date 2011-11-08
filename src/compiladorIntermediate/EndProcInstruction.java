/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorIntermediate;

/**
 *
 * @author gmaiztegi
 */
public class EndProcInstruction implements Instruction {

    @Override
    public String getText() {
        return "finproc;";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
