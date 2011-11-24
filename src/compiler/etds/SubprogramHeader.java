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
    
    public String progid;
    
    public SubprogramHeader(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        Token idtoken;
        Symbol id;
        
        expectString("procedure", true);
        
        idtoken = expectType(TokenType.IDENTIFIER);
        id = addSymbol(idtoken.getMatch(), Symbol.PROCEDURE);
        addInstruction(new ProcInstruction(id));
        
        pushContext();
        
        new Arguments(context).execute();
        
        expectString("is");
    }
    
}
