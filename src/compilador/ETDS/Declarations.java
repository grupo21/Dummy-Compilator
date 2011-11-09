/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.*;
import compilador.Token.*;
import compiladorIntermediate.DeclarationInstruction;
import compilator.Symbol.Symbol;
import java.util.Iterator;

/**
 *
 * @author gmaiztegi
 */
public class Declarations extends AbstractETDS {

    public Declarations(CompilerContext context) {
        super(context);
    }
    
    @Override
    public void execute() throws CompilerException {
        IdentifierList idList;
        Type type;
        
        Iterator<String> iter;
        
        try {
            expectString("var");
        } catch (SyntaxException ex) {
            revert();
            return;
        }
        
        idList = new IdentifierList(context);
        idList.execute();

        expectString(":");

        type = new Type(context);
        type.execute();
        
        expectString(";");
        
        iter = idList.nameList.iterator();
        
        while (iter.hasNext()) {
            Symbol var;
            var = addSymbol(iter.next(), type.type);
            addInstruction(new DeclarationInstruction(var));
        }
        
        
        new Declarations(context).execute();
    }
    
}