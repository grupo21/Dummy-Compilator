package compilator.ETDS;

import compilator.*;
import compilator.Token.*;
import compilator.Symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Variable extends AbstractETDS {
    
    public Symbol var;

    public Variable(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        Token token = expectType(TokenType.IDENTIFIER, true);
        var = getSymbol(token.getMatch());
    }
    
}
