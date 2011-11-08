/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.SemanticException;

/**
 *
 * @author gmaiztegi
 */
public interface ETDS {
    
    public void execute() throws SyntaxException, SemanticException;
}
