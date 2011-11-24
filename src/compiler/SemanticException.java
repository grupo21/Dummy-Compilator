package compiler;

/**
 * Señaliza un error semántico en el código fuente.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class SemanticException extends CompilerException {
    
    public SemanticException() {
        super();
    }

    public SemanticException(String string) {
        super(string);
    }
}
