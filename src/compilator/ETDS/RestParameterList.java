/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;;
import compilator.Intermediate.*;
import compilator.Symbol.*;
import java.util.Iterator;

/**
 *
 * @author gmaiztegi
 */
class RestParameterList extends AbstractETDS {

    public RestParameterList(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        
        IdentifierList idlist;
        ClassPair classpair;
        Type type;
        Iterator<String> iter;
        
        try {
            expectString(";");
        } catch (SyntaxException ex) {
            revert();
            return;
        }
        
        
        idlist = new IdentifierList(context);
        idlist.execute();
        
        expectString(":");
        
        classpair = new ClassPair(context);
        classpair.execute();
        
        type = new Type(context);
        type.execute();
        
        iter = idlist.nameList.iterator();
        while (iter.hasNext()) {
            Symbol var = addSymbol(iter.next(), type.type);
            addInstruction(new ParameterDeclarationInstruction(var, classpair.reference));
        }
    }
    
}
