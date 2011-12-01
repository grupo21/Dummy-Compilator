package compiler.etds;

import compiler.*;
import compiler.intermediate.Marker;
import java.util.List;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class SimpleBoolean extends AbstractETDS {
    
    public List<Marker> truelist, falselist;

    public SimpleBoolean(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            expectString("not", true);
            
            SimpleBoolean bool = new SimpleBoolean(context);
            bool.execute();
            
            truelist = bool.falselist;
            falselist = bool.truelist;
            
            return;
            
        } catch (NoMatchException ex) {
            revert();
        }
        
        try {
            expectString("(", true);
            
            Disjunction disjunction = new Disjunction(context);
            disjunction.execute();
            
            expectString(")");
            
            truelist = disjunction.truelist;
            falselist = disjunction.falselist;
            
            return;
            
        } catch (NoMatchException ex) {
            revert();
        }
        
        Comparation comparation = new Comparation(context);
        comparation.execute();
        
        truelist = comparation.truelist;
        falselist = comparation.falselist;
    }
    
}
