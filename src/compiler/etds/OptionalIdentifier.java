package compiler.etds;

import compiler.*;
import compiler.token.*;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class OptionalIdentifier extends AbstractETDS {
    
    public String id;
    
    public OptionalIdentifier(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        Token idtoken;
        
        try {
            idtoken = expectType(TokenType.IDENTIFIER);
            
            id = idtoken.getMatch();
            
        } catch (SyntaxException ex) {
            revert();
            return;
        }
    }
}
