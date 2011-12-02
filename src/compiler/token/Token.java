package compiler.token;

/**
 * Clase que representa a un Token y su información
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Token implements Cloneable {
    
    private String match;
    private int type, linenum;
    
    /**
     * Construye un token con la cadena casada y el tipo.
     * @param match Cadena de caracteres que componen el Token
     * @param type Identificador del tipo de token
     */
    public Token(String match, int type, int linenum)
    {
        this.match = match;
        this.type = type;
        this.linenum = linenum;
    }
    
    /**
     * Devuelve la cadena de caracteres que ha casado.
     * @return La cadena de caracteres del token.
     */
    public String getMatch() {
        return match;
    }
    
    /**
     * Devuelve información detallada acerca del token.
     * @return Cadena imprimible para debug.
     */
    public String getInfo()
    {
        return match + "\t\t" + TokenType.toString(type);
    }
    
    /**
     * Devuelve el tipo de token.
     * @return Tipo de token.
     */
    public int getType() {
        return type;
    }
    
    /**
     * Comprueba que el token sea del tipo indicado
     * @param type Identificador del tipo de token
     * @return Verdadero si los tipos son iguales, falso en caso contrario
     */
    public Boolean isType(int type)
    {
        return this.type == type;
    }
    
    /**
     * Devuelve el número de línea en el que se encontraba el token.
     * @return El número de línea.
     */
    public int getLineNumber() {
        return linenum;
    }
}
