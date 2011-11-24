package compiler.intermediate;

/**
 * Instrucción que escribe un salto de línea en la salida.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class WritelnInstruction implements Instruction {

    @Override
    public String getText() {
        return "writeln;";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
