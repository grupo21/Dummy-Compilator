package compiler.etds;

import compiler.*;
import compiler.intermediate.DeclarationInstruction;
import compiler.symbol.Symbol;
import compiler.token.Token;
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
        
        for (Token token: idList.nameList) {
            Symbol var = addSymbol(token, type.type);
            addInstruction(new DeclarationInstruction(var));
        }
        
        new Declarations(context).execute();
    }
    
}