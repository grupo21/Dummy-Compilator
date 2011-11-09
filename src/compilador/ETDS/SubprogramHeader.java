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
public class SubprogramHeader extends AbstractETDS {
    
    public String progid;
    
    public SubprogramHeader(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
