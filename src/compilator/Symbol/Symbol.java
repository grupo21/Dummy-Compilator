package compilator.Symbol;

/**
 * Clase que represente una variable o símbolo.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Symbol {
    public static final int INTEGER = 0;
    public static final int FLOAT = 1;
    public static final int PROCEDURE = 2;
    public static final int FUNCTION = 3;
    public static final int PROGRAM = 4;
    
    protected String name;
    protected int type;
    
    /**
     * Contruye una variable con su nombre y tipo.
     * @param name El identificador de la variable.
     * @param type El tipo de la variable.
     */
    public Symbol(String name, int type) {
        this.name = name;
        this.type = type;
    }
    
    /**
     * Devuelve el nombre de la variable.
     * @return El nombre de la variable.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Devuelve el tipo de la variable.
     * @return El tipo de la variable.
     */
    public int getType() {
        return this.type;
    }
    
    /**
     * Comprueba que la variable sea del tipo indicado.
     * @param type El tipo con el que comparar.
     * @return Verdadero si es de dicho tipo, falso en caso contrario.
     */
    public boolean isType(int type) {
        return type == this.type;
    }
}
