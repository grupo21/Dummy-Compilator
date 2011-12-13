/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.token;

/**
 * Programa de prueba para el analizador léxico
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class IntegerToken extends Token {

    protected int value;
    
    /**
     * Construye un token del tipo entero y parsea su valor numérico
     * @param match La cadena casada
     */
    public IntegerToken(String match, int linenum) {
        super(match, INTEGER, linenum);
        
        this.value = Integer.parseInt(match);
    }
    
    /**
     * Obtiene el valor numérico del token.
     * @return La representación en entero de lo casado.
     */
    public int getValue() {
        return this.value;
    }
}
