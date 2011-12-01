package compiler.etds;

import compiler.*;
import compiler.intermediate.Marker;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class RestConjunction extends AbstractETDS {
    
    public List<Marker> htruelist;
    public List<Marker> truelist, falselist;

    public RestConjunction(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            expectString("and", true);
            
            SimpleBoolean bool = new SimpleBoolean(context);
            RestConjunction rest = new RestConjunction(context);
            
            completeGotos(htruelist, getMarker());
            
            bool.execute();
            rest.htruelist = bool.truelist;
            rest.execute();
            
            truelist = rest.truelist;
            falselist = bool.falselist;
            falselist.addAll(rest.falselist);
            
            return;
            
        } catch (NoMatchException ex) {
            revert();
        }
        
        truelist = htruelist;
        falselist = new LinkedList<Marker>();
    }
    
}
