/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import java.util.List;

/**
 *
 * @author gmaiztegi
 */
public class NoMatchException extends SyntaxException {
    
    public NoMatchException(SyntaxException ex) {
        super(ex);
    }
    
    public NoMatchException(String got, String expected) {
        super(got, expected);
    }
    
    public NoMatchException(String got, List <String> expected) {
        super(got, expected);
    }
}
