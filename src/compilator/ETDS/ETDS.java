package compilator.ETDS;

import compilator.CompilerException;

/**
 * Interfaz a implementar por todas las ETDSs
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public interface ETDS {
    
    /**
     * Ejecuta la ETDS
     * @throws CompilerException si ha habido algún problema de compilación.
     */
    public void execute() throws CompilerException;
}
