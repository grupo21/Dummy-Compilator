/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Token.*;
import compilator.Symbol.Symbol;

/**
 *
 * @author gmaiztegi
 */
public class Type extends AbstractETDS {
    
    public int type;
    
    public Type(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        Token typetoken;
        
        typetoken = expectType(TokenType.RESERVED);
        
        if (typetoken.getMatch().equals("integer")) {
            type = Symbol.INTEGER;
        }
        else if (typetoken.getMatch().equals("float")) {
            type = Symbol.FLOAT;
        } else {
            throw new SyntaxException("Se esperaba \"integer\" o \"float\", pero se ha obtenido "+typetoken.getMatch());
        }
    }
}
