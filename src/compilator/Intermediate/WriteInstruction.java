package compilator.Intermediate;

import compilator.Symbol.*;

/**
 * Instrucción que escribe un valor por la salida.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class WriteInstruction implements Instruction {

    protected Symbol var;
    
    /**
     * Crea una instrucción que lee un valor a una variable.
     * @param var Variable a la que leer.
     * @throws IncompatibleTypesException si la varaible no es apta para contener un valor (no es entero o real).
     */
    public WriteInstruction(Symbol var) throws IncompatibleTypesException {
        TypeSemantics.checkScalar(var);
        this.var = var;
    }
    
    @Override
    public String getText() {
        return "write "+var.getName()+";";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
