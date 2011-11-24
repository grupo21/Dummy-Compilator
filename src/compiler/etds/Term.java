package compiler.etds;

import compiler.*;
import compiler.symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
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
