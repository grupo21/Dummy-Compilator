/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Symbol.Symbol;

/**
 *
 * @author gmaiztegi
 */
class Term extends AbstractETDS {
    
    public Symbol result;

    public Term(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
