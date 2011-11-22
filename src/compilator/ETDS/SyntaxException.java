/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.CompilerException;

/**
 *
 * @author gmaiztegi
 */
public class SyntaxException extends CompilerException {
    
    public SyntaxException() {
        super();
    }
    
    public SyntaxException(String str) {
        super(str);
    }
}
