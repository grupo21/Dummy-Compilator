/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.CompilerContext;
import compilador.CompilerException;
import compilator.Symbol.*;

/**
 *
 * @author gmaiztegi
 */
public class SimpleExpression extends AbstractETDS {
    
    public Symbol result;

    public SimpleExpression(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
