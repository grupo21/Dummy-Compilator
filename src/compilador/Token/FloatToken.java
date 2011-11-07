/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.Token;

/**
 * Token representando un flotante
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class FloatToken extends Token {
    
    protected float value;

    public FloatToken(String match, int type) {
        super(match, type);
        
        Float.parseFloat(match);
    }
    
    public float getValue() {
        return this.value;
    }
}
