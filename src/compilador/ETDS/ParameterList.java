/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.CompilerContext;
import compilador.CompilerException;
import compiladorIntermediate.ParameterDeclarationInstruction;
import compilator.Symbol.Symbol;
import java.util.Iterator;

/**
 *
 * @author gmaiztegi
 */
class ParameterList extends AbstractETDS {

    public ParameterList(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        IdentifierList idlist;
        ClassPair classpair;
        Type type;
        Iterator<String> iter;
        
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
        
        new RestParameterList(context).execute();
    }
    
}
