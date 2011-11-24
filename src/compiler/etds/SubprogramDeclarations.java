package compiler.etds;

import compiler.*;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class SubprogramDeclarations extends AbstractETDS {
    
    public SubprogramDeclarations(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            new SubprogramDeclaration(context).execute();
        } catch (NoMatchException ex) {
            revert();
            return;
        }
        
        new SubprogramDeclarations(context).execute();
    }
    
}
