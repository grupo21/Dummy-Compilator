/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Intermediate;

/**
 *
 * @author gmaiztegi
 */
public class EndProgInstruction implements Instruction {

    @Override
    public String getText() {
        return "finprog;";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
