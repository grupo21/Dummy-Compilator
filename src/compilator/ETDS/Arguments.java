package compilator.ETDS;

import compilator.*;

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
        expectString("(");
        
        new ParameterList(context).execute();
        
        expectString(")");
    }
    
}
