package compiler.etds;

import compiler.CompilerContext;
import compiler.CompilerException;
import compiler.intermediate.IfGotoInstruction;
import compiler.symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class RestComparation extends AbstractETDS {
    
    public Symbol hsymbol;
    
    public RestComparation(CompilerContext context) {
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
