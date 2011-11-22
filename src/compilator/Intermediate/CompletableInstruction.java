/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Intermediate;

/**
 *
 * @author gmaiztegi
 */
public interface CompletableInstruction extends Instruction {
    public void complete(Marker marker);
}
