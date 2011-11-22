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
public class SubprogramDeclarations extends AbstractETDS {
    
    public SubprogramDeclarations(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        new SubprogramDeclaration(context).execute();
        new SubprogramDeclarations(context).execute();
    }
    
}
