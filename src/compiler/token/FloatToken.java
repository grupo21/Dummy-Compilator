package compiler.token;

/**
 * Token representando un flotante
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class FloatToken extends Token {
    
    protected float value;

    /**
     * Construye el token con la cadena casada y obtiene su valor numérico.
     * @param match La cadena casada.
     */
    public FloatToken(String match) {
        super(match, TokenType.FLOAT);
        
        Float.parseFloat(match);
    }
    
    /**
     * Obtiene el valor numérico del token.
     * @return La representación numérica del string casado.
     */
    public float getValue() {
        return this.value;
    }
}
