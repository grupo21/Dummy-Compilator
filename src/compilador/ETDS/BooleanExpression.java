/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.CompilerContext;
import compilador.CompilerException;
import compiladorIntermediate.*;
import java.util.List;

/**
 *
 * @author gmaiztegi
 */
class BooleanExpression extends AbstractETDS {
    
    public List<Marker> truelist, falselist;

    public BooleanExpression(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
