package compiler.etds;

import compiler.CompilerContext;
import compiler.CompilerException;
import compiler.intermediate.OperationInstruction;
import compiler.symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class RestSimpleExpression extends AbstractETDS {
    
    public Symbol hsymbol;
    public Symbol result;
    
    public RestSimpleExpression(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        
        Term term;
        String operation = null;
        
        try {
            expectString("+");
            operation = "+";
        } catch (SyntaxException e) {
            revert();
            
            try {
                expectString("-");
                operation = "-";
            } catch (SyntaxException ex) {
                revert();
                result = hsymbol;
                return;
            }
        }
        
        term = new Term(context);
        term.execute();
        
        result = getNewSymbol(hsymbol.getType());
        
        addInstruction(new OperationInstruction(result, hsymbol, term.result, operation));
    }
    
}
