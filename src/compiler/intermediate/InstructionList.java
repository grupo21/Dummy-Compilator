package compiler.intermediate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Lista de instrucciones de código intermedio.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class InstructionList implements Iterable<Instruction> {
    
    protected List<Instruction> instructions;
    
    /**
     * Construye una lista de instrucciones vacía.
     */
    public InstructionList() {
        instructions = new ArrayList<Instruction>();
    }
    
    /**
     * Añade instruction a la lista de instrucciones.
     * @param instruction La instrucción a añadir.
     * @return Marcador a la instrucción recién añaida.
     */
    public Marker add(Instruction instruction) {
        instructions.add(instruction);
        return new Marker(this, instructions.size()-1);
    }
    
    /**
     * Obtiene la instrucción referenciada por el marcador.
     * @param marker Referencia a la instrucción.
     * @return La instrucción referenciada.
     */
    public Instruction get(Marker marker) {
        if (marker.getList() != this) {
            throw new IllegalArgumentException();
        }
        
        return instructions.get(marker.getIndex());
    }
    
    /**
     * Obtiene un marcador a la próxima intrucción que se vaya a añadir en la lista.
     * @return El marcador.
     */
    public Marker getCurrentMarker() {
        return new Marker(this, instructions.size());
    }

    @Override
    public Iterator<Instruction> iterator() {
        return instructions.iterator();
    }
}
