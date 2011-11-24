package compilator.Intermediate;

/**
 * Instrucción de salto incondicional.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class GotoInstruction implements Instruction, CompletableInstruction {
    
    protected Marker where;
    
    /**
     * Construye la instrucción de salto incompleta.
     */
    public GotoInstruction() {
        where = null;
    }
    
    /**
     * Construye la instrucción de tal manera que salte a where.
     * @param where La referencia a la que debe saltar esta instrucción.
     */
    public GotoInstruction(Marker where) {
        this.where = where;
    }
    
    @Override
    public String getText() {
        String idx = where != null ? String.valueOf(where.index) : "__";
        return "goto "+idx+";";
    }

    @Override
    public boolean isComplete() {
        return where != null;
    }

    @Override
    public void complete(Marker marker) {
        where = marker;
    }
    
}
