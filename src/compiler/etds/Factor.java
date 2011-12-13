package compiler.etds;

import compiler.*;
import compiler.symbol.Symbol;
import compiler.token.*;

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
            token = expectType(Token.IDENTIFIER);
        } catch (SyntaxException e) {
            revert();
            
            try {
                token = expectType(Token.INTEGER);
            } catch (SyntaxException ee) {
                revert();
                
                try {
                    token = expectType(Token.FLOAT);
                } catch (SyntaxException eee) {
                    revert();
                    
                    expectString("(");
                    
                    SimpleExpression expr = new SimpleExpression(context);
                    expr.execute();
                    
                    expectString(")");
                    
                    result = expr.result;
                    
                    return;
                }
                
                result = new Symbol(token.getMatch(), Symbol.FLOAT, token.getLineNumber());
                
                return;
            }
            
            result = new Symbol(token.getMatch(), Symbol.INTEGER, token.getLineNumber());
            
            return;
        }
        
        result = getSymbol(token);
    }
    
}
