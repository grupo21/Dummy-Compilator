/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.*;
import compilador.Token.*;
import compiladorIntermediate.*;
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
        
        try {
            expectString("procedure");
        } catch (SyntaxException ex) {
            revert();
            return;
        }
        
        idtoken = expectType(TokenType.IDENTIFIER);
        id = addSymbol(idtoken.getMatch(), Symbol.PROCEDURE);
        addInstruction(new ProcInstruction(id));
        
        new Arguments(context).execute();
        
        expectString("is");
    }
    
}
