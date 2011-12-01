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
class RestDisjunction extends AbstractETDS {

    public List<Marker> hfalselist;
    public List<Marker> truelist, falselist;

    public RestDisjunction(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            expectString("or", true);

            Conjunction conjunction = new Conjunction(context);
            RestDisjunction rest = new RestDisjunction(context);

            completeGotos(hfalselist, getMarker());
            
            conjunction.execute();
            rest.hfalselist = conjunction.falselist;
            rest.execute();

            falselist = rest.falselist;
            truelist = conjunction.truelist;
            truelist.addAll(rest.truelist);
            
            return;

        } catch (NoMatchException ex) {
            revert();
        }

        truelist = new LinkedList<Marker>();
        falselist = hfalselist;
    }
}
