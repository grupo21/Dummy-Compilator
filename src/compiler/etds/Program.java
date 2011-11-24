package compiler.etds;

import compiler.token.*;
import compiler.*;
import compiler.intermediate.HaltInstruction;
import compiler.intermediate.ProgInstruction;
import compiler.symbol.Symbol;

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
