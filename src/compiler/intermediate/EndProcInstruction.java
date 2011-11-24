package compiler.intermediate;

/**
 * Instrucción que marca el final de un subprograma.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class EndProcInstruction implements Instruction {

    @Override
    public String getText() {
        return "finproc;";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
