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
class ClassPair extends AbstractETDS {
    
    public boolean reference;

    public ClassPair(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        RestClassPair rest;
        try {
            expectString("in");
            
        } catch (SyntaxException ex) {
            expectString("out");
            reference = true;
            return;
        }
        
        rest = new RestClassPair(context);
        rest.execute();
        
        reference = rest.reference;
    }
}
