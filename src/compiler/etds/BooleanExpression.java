package compiler.etds;

import compiler.*;
import compiler.intermediate.*;
import java.util.LinkedList;
import java.util.List;

/**
 * ETDS que compila una expresión booleana.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class BooleanExpression extends AbstractETDS {
    
    public List<Marker> truelist, falselist;

    public BooleanExpression(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        SimpleExpression expr;
        RestBooleanExpression rest;
        
        expr = new SimpleExpression(context);
        expr.execute();
        
        truelist = new LinkedList<Marker>();
        truelist.add(getMarker());
        
        falselist = new LinkedList<Marker>();
        falselist.add(getMarker().add(1));
        
        rest = new RestBooleanExpression(context);
        rest.hsymbol = expr.result;
        rest.execute();
        
        addInstruction(new GotoInstruction());
    }
    
}
