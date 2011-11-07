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
public abstract class AbstractETDS {
    
    public abstract void execute(AbstractETDS parent);
    
    public Token expectType(int type) {
        Token token;
        
        token = Tokenizer.tokenizer.nextElement();
        
        if (!token.isType(type)) {
            throw new UnexpectedTokenException();
        }
        
        return token;
    }
    
    public Token expectString(String str) {
        Token token;
        
        token = Tokenizer.tokenizer.nextElement();
        
        if (!token.getMatch().equals(str)) {
            throw new UnexpectedTokenException();
        }
        
        return token;
    }
}
