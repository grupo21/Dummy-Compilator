package compilator.ETDS;

import compilator.CompilerContext;
import compilator.CompilerException;
import compilator.Intermediate.IfGotoInstruction;
import compilator.Symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class RestBooleanExpression extends AbstractETDS {
    
    public Symbol hsymbol;
    
    public RestBooleanExpression(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        SimpleExpression expr;
        String operation;
        
        try {
            expectString("=");
            operation = "=";
        } catch (SyntaxException e) {
            revert();
            
            try {
                expectString("<");
                operation = "<";
            } catch (SyntaxException ee) {
                revert();
                
                try {
                    expectString(">");
                    operation = ">";
                } catch (SyntaxException eee) {
                    revert();
                    
                    try {
                        expectString("<=");
                        operation = "<=";
                    } catch (SyntaxException eeee) {
                        revert();
                        expectString(">=");
                        operation = ">=";
                    }
                    
                }
            }
        }
        
        expr = new SimpleExpression(context);
        expr.execute();
        
        addInstruction(new IfGotoInstruction(hsymbol, expr.result, operation));
    }
}
