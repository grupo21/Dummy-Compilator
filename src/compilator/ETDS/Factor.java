package compilator.ETDS;

import compilator.*;
import compilator.Symbol.Symbol;
import compilator.Token.*;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class Factor extends AbstractETDS {
    
    public Symbol result;
    
    public Factor(CompilerContext context) {
        super(context);
    }
    
    @Override
    public void execute() throws CompilerException {
        Token token;
        
        try {
            token = expectType(TokenType.IDENTIFIER);
        } catch (SyntaxException e) {
            revert();
            
            try {
                token = expectType(TokenType.INTEGER);
            } catch (SyntaxException ee) {
                revert();
                
                try {
                    token = expectType(TokenType.FLOAT);
                } catch (SyntaxException eee) {
                    revert();
                    
                    expectString("(");
                    
                    SimpleExpression expr = new SimpleExpression(context);
                    expr.execute();
                    
                    expectString(")");
                    
                    result = expr.result;
                    
                    return;
                }
                
                result = new Symbol(token.getMatch(), Symbol.FLOAT);
                
                return;
            }
            
            result = new Symbol(token.getMatch(), Symbol.INTEGER);
            
            return;
        }
        
        result = getSymbol(token.getMatch());
    }
    
}
