package compilator.ETDS;

import compilator.*;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class RestClassPair extends AbstractETDS {
    
    public boolean reference;

    public RestClassPair(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            expectString("out");
            reference = true;
        } catch (SyntaxException ex) {
            revert();
            reference = false;
        }
    }
}
