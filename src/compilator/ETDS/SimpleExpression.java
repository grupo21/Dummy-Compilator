package compilator.ETDS;

import compilator.*;
import compilator.Symbol.*;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
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
