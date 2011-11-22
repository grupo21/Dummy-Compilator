/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Intermediate.*;
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
