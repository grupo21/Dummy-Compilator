package compiler.etds;

import compiler.*;
import compiler.token.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class RestIdentifierList extends AbstractETDS {
    
    public List<Token> nameList;

    public RestIdentifierList(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        
        try {
            expectString(",");
        } catch (SyntaxException ex) {
            revert();
            
            nameList = new ArrayList<Token>();
            
            return;
        }
        
        Token idtoken = expectType(Token.IDENTIFIER);
        RestIdentifierList rest = new RestIdentifierList(context);
        
        rest.execute();
        
        nameList = rest.nameList;
        
        nameList.add(idtoken);
    }
}
