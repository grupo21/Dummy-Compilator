/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.Token.*;
import compilator.*;
import compilator.Intermediate.ProgInstruction;
import compilator.Symbol.Symbol;

/**
 * Token representando un flotante
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Program extends AbstractETDS {
    
    public Program(CompilerContext context) {
        super(context);
    }
    
    @Override
    public void execute() throws CompilerException {
        
        Token id;
        Symbol program;
        
        expectString("program");
        
        id = expectType(TokenType.IDENTIFIER);
        program = addSymbol(id.getMatch(), Symbol.PROGRAM);
        
        expectString("is");
        
        addInstruction(new ProgInstruction(program));
        
        new Declarations(context).execute();
        new SubprogramDeclarations(context).execute();
    }
}
