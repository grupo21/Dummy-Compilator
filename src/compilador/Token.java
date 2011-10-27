package compilador;

/**
 * Clase que representa a un Token y su información
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Token implements Cloneable {
    
    private String match;
    
    private int type;
    
    /**
     * 
     * @param match Cadena de caracteres que componen el Token
     * @param type Identificador del tipo de token
     */
    public Token(String match, int type)
    {
        this.match = match;
        this.type = type;
    }
    
    public String getMatch() {
        return this.match;
    }
    
    /**
     * Imprime en pantalla información debug sobre el token
     */
    public void printInfo()
    {
        System.out.println(this.match+"\t\t"+TokenType.toString(this.type));
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
}
