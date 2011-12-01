package compiler.etds;

import compiler.*;
import compiler.intermediate.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class Comparation extends AbstractETDS {
    
    public List<Marker> truelist, falselist;

    public Comparation(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        SimpleExpression expr;
        RestComparation rest;
        
        expr = new SimpleExpression(context);
        expr.execute();
        
        rest = new RestComparation(context);
        rest.execute();
        
        truelist = new LinkedList<Marker>();
        falselist = new LinkedList<Marker>();
        
        truelist.add(addInstruction(new IfGotoInstruction(expr.result, rest.result, rest.operator)));
        falselist.add(addInstruction(new GotoInstruction()));
    }
    
}
