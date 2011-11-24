package compilator.Intermediate;

import compilator.Symbol.*;

/**
 * Instrucción de asignación de una variable a otra.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class AsignationInstruction implements Instruction {
    
    protected String idout, idin;

    public AsignationInstruction(Symbol out, Symbol in) throws IncompatibleTypesException {
        
        TypeSemantics.checkScalar(out);
        TypeSemantics.checkScalar(in);
        TypeSemantics.checkEqual(in, out);
        
        this.idout = out.getName();
        this.idin = in.getName();
    }
    
    @Override
    public String getText() {
        return idout+" := "+idin+";";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
