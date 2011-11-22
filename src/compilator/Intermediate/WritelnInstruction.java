/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Intermediate;

/**
 *
 * @author gmaiztegi
 */
public class WritelnInstruction implements Instruction {

    @Override
    public String getText() {
        return "writeln;";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
