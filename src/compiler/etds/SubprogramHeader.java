package compiler.etds;

import compiler.*;
import compiler.token.*;
import compiler.intermediate.*;
import compiler.symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class SubprogramHeader extends AbstractETDS {
    
    public Symbol progid;
    
    public SubprogramHeader(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        Token idtoken;
        
        expectString("procedure", true);
        
        idtoken = expectType(Token.IDENTIFIER);
        progid = addSymbol(idtoken, Symbol.PROCEDURE);
        addInstruction(new ProcInstruction(progid));
        
        pushContext();
        
        new Arguments(context).execute();
        
        expectString("is");
    }
    
}
