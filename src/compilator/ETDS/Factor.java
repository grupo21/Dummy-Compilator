/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Symbol.Symbol;
import compilator.Token.*;

/**
 *
 * @author gmaiztegi
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
