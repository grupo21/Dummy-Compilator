/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Intermediate.EndProcInstruction;

/**
 *
 * @author gmaiztegi
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
