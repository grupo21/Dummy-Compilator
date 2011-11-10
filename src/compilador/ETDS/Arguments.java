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
class Arguments extends AbstractETDS {

    public Arguments(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        expectString("(");
        
        new ParameterList(context).execute();
        
        expectString(")");
    }
    
}
