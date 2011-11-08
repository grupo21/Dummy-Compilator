/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.*;
import compilador.Token.*;
import compilator.Symbol.Symbol;
import java.util.List;

/**
 *
 * @author gmaiztegi
 */
public class IdentifierList extends AbstractETDS {
    
    public List<String> nameList;

    public IdentifierList(CompilerContext context) {
        super(context);
    }
    
    @Override
    public void execute() throws CompilerException {
        
        Token idtoken = expectType(TokenType.IDENTIFIER);
        RestIdentifierList rest = new RestIdentifierList(context);
        
        rest.execute();
        
        nameList = rest.nameList;
        
        nameList.add(idtoken.getMatch());
    }    
}
