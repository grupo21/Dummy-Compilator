package compilator;

/**
 * Señal que indica un fallo cualquiera en la compilación.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class CompilerException extends Exception {

    public CompilerException() {
    }

    public CompilerException(String string) {
        super(string);
    }
    
}
