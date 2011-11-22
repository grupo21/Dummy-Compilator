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
        RestTerm rest;
        Factor factor;
        
        factor = new Factor(context);
        factor.execute();
        
        rest = new RestTerm(context);
        rest.hsymbol = factor.result;
        
        rest.execute();
        
        result = rest.result;
    }
    
}
