package compiler.intermediate;

import compiler.symbol.*;

/**
 * Instrucción que realiza una operación aritmética.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class OperationInstruction extends AsignationInstruction {
    
    protected String idin2;
    protected String operator;
    
    /**
     * Construye la instrucción de operación aritmética.
     * @param out Variable de salida, a la que se le asignará el valor.
     * @param in Variable izquierda de entrada.
     * @param in2 variable derecha de entrada.
     * @param operator Operador aritmético para la operación.
     * @throws IncompatibleTypesException si los tipos de las variables son incompatibles ente ellos.
     */
    public OperationInstruction(Symbol out, Symbol in, Symbol in2, String operator) throws IncompatibleTypesException {
        super(out, in);
        
        TypeSemantics.checkScalar(in2);
        TypeSemantics.checkEqual(in, in2);
        
        idin2 = in2.getName();
        this.operator = operator;
    }

    @Override
    public String getText() {
        return idout+" := "+idin+" "+operator+" "+idin2+";";
    }
    
    
}
