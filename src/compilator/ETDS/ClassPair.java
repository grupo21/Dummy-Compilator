package compilator.ETDS;

import compilator.*;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class ClassPair extends AbstractETDS {
    
    public boolean reference;

    public ClassPair(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        RestClassPair rest;
        try {
            expectString("in");
            
        } catch (SyntaxException ex) {
            revert();
            expectString("out");
            reference = true;
            return;
        }
        
        rest = new RestClassPair(context);
        rest.execute();
        
        reference = rest.reference;
    }
}
