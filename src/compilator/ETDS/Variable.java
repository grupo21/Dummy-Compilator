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
public class Variable extends AbstractETDS {
    
    public Symbol var;

    public Variable(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        Token token = expectType(TokenType.IDENTIFIER);
        var = getSymbol(token.getMatch());
    }
    
}
