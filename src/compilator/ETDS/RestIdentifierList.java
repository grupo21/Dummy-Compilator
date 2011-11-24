package compilator.ETDS;

import compilator.*;
import compilator.Token.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class RestIdentifierList extends AbstractETDS {
    
    public List<String> nameList;

    public RestIdentifierList(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        
        try {
            expectString(",");
        } catch (SyntaxException ex) {
            revert();
            
            nameList = new ArrayList<String>();
            
            return;
        }
        
        Token idtoken = expectType(TokenType.IDENTIFIER);
        RestIdentifierList rest = new RestIdentifierList(context);
        
        rest.execute();
        
        nameList = rest.nameList;
        
        nameList.add(idtoken.getMatch());
    }
}
