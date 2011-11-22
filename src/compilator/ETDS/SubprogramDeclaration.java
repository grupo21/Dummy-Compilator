/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;

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
        
        expectString("endprocedure");
        
        optid = new OptionalIdentifier(context);
        optid.execute();
        
        expectString(";");
        
        // Comprobar que los ids del principio y final son iguales.
    }
    
}
