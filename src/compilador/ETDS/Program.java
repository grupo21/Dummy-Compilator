/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.*;

/**
 * Token representando un flotante
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Program extends AbstractETDS {
    
    private Token id;

    @Override
    public void execute(AbstractETDS parent) {
        this.expectString("program");
        id = this.expectType(TokenType.IDENTIFIER);
        this.expectString("is");
    }
}
