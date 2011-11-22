/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
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
        RestSimpleExpression rest;
        Term term;
        
        term = new Term(context);
        term.execute();
        
        rest = new RestSimpleExpression(context);
        rest.hsymbol = term.result;
        
        rest.execute();
        
        result = rest.result;
    }
    
}
