package compiler.etds;

import compiler.*;
import compiler.intermediate.EndProcInstruction;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class SubprogramDeclaration extends AbstractETDS {
    
    public SubprogramDeclaration(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        SubprogramHeader header;
        OptionalIdentifier optid;
        
        header = new SubprogramHeader(context);
        header.execute();
        
        new Declarations(context).execute();
        
        expectString("begin");
        
        new SentenceList(context).execute();
        
        popContext();
        
        expectString("endprocedure");
        
        optid = new OptionalIdentifier(context);
        optid.execute();
        
        expectString(";");
        
        addInstruction(new EndProcInstruction());
        
        // Comprobar que los ids del principio y final son iguales.
    }
    
}
