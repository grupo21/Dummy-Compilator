package compilator.Intermediate;

/**
 * Interfaz que implementan las instrucciones de salto.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public interface CompletableInstruction extends Instruction {
    /**
     * Completa la instrucción incompleta con el marcador.
     * @param marker Marcador a una instrucción a la que saltar.
     */
    public void complete(Marker marker);
}
