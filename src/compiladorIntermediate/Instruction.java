/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorIntermediate;

/**
 *
 * @author gmaiztegi
 */
public interface Instruction {
    
    public String getText();    
    public boolean isComplete();
    
    public void complete(Marker marker);
}
