package compiler.etds;

import compiler.*;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class Arguments extends AbstractETDS {

    public Arguments(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            expectString("(", true);
            
            new ParameterList(context).execute();
            
            expectString(")");
        } catch (NoMatchException ex) {
            revert();
        }
    }
    
}
