/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Token.*;

/**
 *
 * @author gmaiztegi
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
