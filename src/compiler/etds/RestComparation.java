package compiler.etds;

import compiler.CompilerContext;
import compiler.CompilerException;
import compiler.symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class RestComparation extends AbstractETDS {
    
    public Symbol result;
    public String operator;
    
    public RestComparation(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        SimpleExpression expr;
        
        try {
            expectString("=");
            operator = "=";
        } catch (SyntaxException e) {
            revert();
            
            try {
                expectString("<");
                operator = "<";
            } catch (SyntaxException ee) {
                revert();
                
                try {
                    expectString(">");
                    operator = ">";
                } catch (SyntaxException eee) {
                    revert();
                    
                    try {
                        expectString("<=");
                        operator = "<=";
                    } catch (SyntaxException eeee) {
                        revert();
                        expectString(">=");
                        operator = ">=";
                    }
                    
                }
            }
        }
        
        expr = new SimpleExpression(context);
        expr.execute();
        result = expr.result;
    }
}
