/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.Token.*;
import compilador.*;
import compilator.Symbol.RedefinedSymbolException;
import compilator.Symbol.Symbol;

/**
 * Token representando un flotante
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Program extends AbstractETDS {
    
    protected Token id;
    protected Symbol program;
    
    public Program(CompilerContext context) {
        super(context);
    }
    
    @Override
    public void execute() throws SyntaxException, RedefinedSymbolException {
        this.expectString("program");
        
        id = this.expectType(TokenType.IDENTIFIER);
        program = addSymbol(id.getMatch(), Symbol.PROGRAM);
        
        this.expectString("is");
    }
}
