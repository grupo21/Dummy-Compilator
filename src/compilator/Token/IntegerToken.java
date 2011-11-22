/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Token;

/**
 * Programa de prueba para el analizador léxico
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class IntegerToken extends Token {

    protected int value;
    
    public IntegerToken(String match, int type) {
        super(match, type);
        
        this.value = Integer.parseInt(match);
    }
    
    public int getValue() {
        return this.value;
    }
}
