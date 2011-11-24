/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Token.*;
import compilator.Intermediate.*;
import compilator.Symbol.Symbol;

/**
 *
 * @author gmaiztegi
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
