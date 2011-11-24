package compilator.Intermediate;

/**
 * Instrucción que marca el final del programa principal.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class HaltInstruction implements Instruction {

    @Override
    public String getText() {
        return "halt;";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
