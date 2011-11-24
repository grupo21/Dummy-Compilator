/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Intermediate;

import compilator.Symbol.*;

/**
 * Instrucción que lee un valor de la entrada.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class ReadInstruction implements Instruction {
    
    protected Symbol var;
    
    /**
     * Crea una instrucción de lectura de la entrada a la variable.
     * @param var Símbolo que represente la variable.
     * @throws IncompatibleTypesException si la variable no es apta para ser leída.
     */
    public ReadInstruction(Symbol var) throws IncompatibleTypesException {
        TypeSemantics.checkScalar(var);
        this.var = var;
    }
    
    @Override
    public String getText() {
        return "read "+var.getName()+";";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
    
}
