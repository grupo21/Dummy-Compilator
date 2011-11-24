package compilator.Intermediate;

/**
 * Marcador a una instrucción en una lista de instrucciones.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Marker {
    
    protected int index;
    protected InstructionList list;
    
    /**
     * Construye la referencia a la instrucción.
     * @param list Referencia a la lista de instrucciones.
     * @param idx El índice de dónde se encuentra la instrucción.
     */
    Marker(InstructionList list, int idx) {
        this.list = list;
        this.index = idx;
    }
    
    /**
     * Devuelve la referencia numérica de la instrucción.
     * @return La referencia numérica.
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * Devuelve un marcador modificado al que se le ha sumado i a su índice.
     * @param i El desplazamiento a sumar al nuevo marcador.
     * @return El nuevo marcador con el desplazamiento sumado.
     */
    public Marker add(int i) {
        return new Marker(list, index+i);
    }
    
    /**
     * Devuelve la referencia a la lista de instrucciones.
     * @return La lista de instrucciones.
     */
    public InstructionList getList() {
        return list;
    }
    
    /**
     * Devuelve la insrucción referenciada, que se obtiene de la lista.
     * @return La insrucción referenciada.
     */
    public Instruction getInstruction() {
        return list.get(this);
    }
}
