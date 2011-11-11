/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.CompilerContext;
import compilador.CompilerException;

/**
 *
 * @author gmaiztegi
 */
class RestClassPair extends AbstractETDS {
    
    public boolean reference;

    public RestClassPair(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            expectString("out");
            reference = true;
        } catch (SyntaxException ex) {
            reference = false;
        }
    }
}
