package compiler.etds;

import compiler.*;
import compiler.intermediate.ParameterDeclarationInstruction;
import compiler.symbol.Symbol;
import compiler.token.Token;
import java.util.Iterator;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
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
        
        for (Token token : idlist.nameList) {
            Symbol var = addSymbol(token, type.type);
            addInstruction(new ParameterDeclarationInstruction(var, classpair.reference));
        }
        
        new RestParameterList(context).execute();
    }
    
}
