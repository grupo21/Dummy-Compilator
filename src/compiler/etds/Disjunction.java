package compiler.etds;

import compiler.*;
import compiler.intermediate.Marker;
import java.util.List;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Disjunction extends AbstractETDS {
    
    public List<Marker> truelist, falselist;
    
    public Disjunction(CompilerContext context) {
        super(context);
    }
    
    @Override
    public void execute() throws CompilerException {
        Conjunction conjunction;
        RestDisjunction rest;
        
        conjunction = new Conjunction(context);
        rest = new RestDisjunction(context);
        
        conjunction.execute();
        rest.hfalselist = conjunction.falselist;
        rest.execute();
        
        falselist = rest.falselist;
        truelist = conjunction.truelist;
        truelist.addAll(rest.truelist);
    }
    
}
