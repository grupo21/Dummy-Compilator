package compiler.etds;

import compiler.*;
import compiler.intermediate.Marker;
import java.util.List;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class Conjunction extends AbstractETDS {
    
    public List<Marker> truelist, falselist;

    public Conjunction(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        SimpleBoolean bool;
        RestConjunction rest;
        
        bool = new SimpleBoolean(context);
        rest = new RestConjunction(context);
        
        bool.execute();
        rest.htruelist = bool.truelist;
        rest.execute();
        
        truelist = rest.truelist;
        falselist = bool.falselist;
        falselist.addAll(rest.falselist);
        
    }
    
}
