package compiler.etds;

import compiler.*;
import compiler.symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Type extends AbstractETDS {
    
    public int type;
    
    public Type(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            expectString("integer");
            type = Symbol.INTEGER;
        } catch (SyntaxException ex) {
            revert();
            expectString("float");
            type = Symbol.FLOAT;
        }
    }
}
