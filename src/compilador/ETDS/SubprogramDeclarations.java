/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.*;

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
        try {
            new SubprogramDeclaration(context).execute();
        } catch (SyntaxException ex) {
            revert();
            return;
        }
        
        new SubprogramDeclarations(context).execute();
    }
    
}
