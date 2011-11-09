/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.*;
import compilador.Token.*;

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
