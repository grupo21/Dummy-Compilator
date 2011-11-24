package compilator.ETDS;

import compilator.Token.*;
import compilator.*;
import compilator.Intermediate.HaltInstruction;
import compilator.Intermediate.ProgInstruction;
import compilator.Symbol.Symbol;

/**
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
        
        pushContext();
        
        new Declarations(context).execute();
        new SubprogramDeclarations(context).execute();
        
        expectString("begin");
        
        new SentenceList(context).execute();
        
        expectString("endprogram");
        
        popContext();
        
        OptionalIdentifier optid = new OptionalIdentifier(context);
        optid.execute();
        expectString(";");
        
        addInstruction(new HaltInstruction());
        
        expectEnd();
    }
}
