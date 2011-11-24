package compiler.etds;

import compiler.CompilerContext;
import compiler.CompilerException;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class ForMode extends AbstractETDS {
    
    public boolean ascending;

    public ForMode(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            expectString("ascending");
            ascending = true;
        } catch (SyntaxException ex) {
            revert();
            expectString("descending");
            ascending = false;
        }
    }
    
}
