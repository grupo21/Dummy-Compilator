package compilator.ETDS;

import compilator.*;
import compilator.Intermediate.OperationInstruction;
import compilator.Symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class RestTerm extends AbstractETDS {
    
    public Symbol hsymbol;
    public Symbol result;
    
    public RestTerm(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        Factor factor;
        String operation;
        
        try {
            expectString("*");
            operation = "*";
        } catch (SyntaxException e) {
            revert();
            try {
                expectString("/");
                operation = "/";
            } catch (SyntaxException ex) {
                revert();
                result = hsymbol;
                return;
            }
        }
        
        factor = new Factor(context);
        factor.execute();
        
        result = getNewSymbol(hsymbol.getType());
        
        addInstruction(new OperationInstruction(result, hsymbol, factor.result, operation));
    }
    
}
