package compiler.etds;

import compiler.*;
import compiler.token.*;
import compiler.symbol.Symbol;

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
        Token token = expectType(Token.IDENTIFIER, true);
        var = getSymbol(token);
    }
    
}
