/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Intermediate.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gmaiztegi
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
