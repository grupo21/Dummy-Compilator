/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Token.*;
import compilator.Symbol.Symbol;

/**
 *
 * @author gmaiztegi
 */
public class Type extends AbstractETDS {
    
    public int type;
    
    public Type(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            expectString("integer");
            type = Symbol.INTEGER;
        } catch (SyntaxException ex) {
            revert();
            expectString("float");
            type = Symbol.FLOAT;
        }
    }
}
