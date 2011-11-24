package compiler.intermediate;

import compiler.symbol.*;

/**
 * Instrucción de salto condicional.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class IfGotoInstruction extends GotoInstruction {
    
    protected Symbol x, y;
    protected String operation;
    
    /**
     * Crea la instrucción de salto completada con el marcador.
     * @param x La variable a la izquierda de la comparación.
     * @param y La variable a la derecha de la comparación.
     * @param operation Operador relacional de la comparación.
     * @param where Referencia a la instrucción a la que se debe saltar.
     */
    public IfGotoInstruction(Symbol x, Symbol y, String operation, Marker where) {
        super(where);
        this.x = x;
        this.y = y;
        this.operation = operation;
    }
    
    /**
     * Crea la instrucción de salto incompleta.
     * @param x La variable a la izquierda de la comparación.
     * @param y La variable a la derecha de la comparación.
     * @param operation Operador relacional de la comparación.
     */
    public IfGotoInstruction(Symbol x, Symbol y, String operation) {
        super();
        this.x = x;
        this.y = y;
        this.operation = operation;
    }
    
    @Override
    public String getText() {
        return "if "+x.getName()+" "+operation+" "+y.getName()+" "+super.getText();
    }
}
