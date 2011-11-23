/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.CompilerContext;
import compilator.CompilerException;

/**
 *
 * @author gmaiztegi
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
