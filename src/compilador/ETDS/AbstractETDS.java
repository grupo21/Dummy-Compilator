/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.Token.*;
import compilador.*;

/**
 * Token representando un flotante
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public abstract class AbstractETDS implements ETDS {
    
    protected CompilerContext context;
    
    public AbstractETDS(CompilerContext context) {
        this.context = context;
    }
    
    public Token expectType(int type) throws SyntaxException {
        Token token;
        
        token = context.tokenizer.nextElement();
        
        if (!token.isType(type)) {
            throw new SyntaxException();
        }
        
        return token;
    }
    
    public Token expectString(String str) throws SyntaxException {
        Token token;
        
        token = context.tokenizer.nextElement();
        
        if (!token.getMatch().equals(str)) {
            throw new SyntaxException();
        }
        
        return token;
    }
}
