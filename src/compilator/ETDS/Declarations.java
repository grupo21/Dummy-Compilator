package compilator.ETDS;

import compilator.*;
import compilator.Intermediate.DeclarationInstruction;
import compilator.Symbol.Symbol;
import java.util.Iterator;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
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