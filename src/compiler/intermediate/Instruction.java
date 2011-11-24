package compiler.intermediate;

/**
 * Interfaz a implementar por las instrucciones de código intermedio.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public interface Instruction {
    /**
     * Obtiene la instrucción en formato de texto.
     * @return El texto de la instrucción
     */
    public String getText();
    
    /**
     * Comprueba si la expresión está completa, válido para saltos.
     * @return Verdadero si la expresión está completa. Falso en caso contrario.
     */
    public boolean isComplete();
}
