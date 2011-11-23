/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;
import compilator.Intermediate.*;

/**
 *
 * @author gmaiztegi
 */
class Sentence extends AbstractETDS {

    public Sentence(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        
        Variable var = new Variable(context);
        
        try {
            var.execute();
        } catch (SyntaxException e) {
            revert();
            
            try {
                expectString("if");
            } catch(SyntaxException ee) {
                revert();
                
                try {
                    expectString("while");
                } catch (SyntaxException eee) {
                    revert();
                    
                    try {
                        expectString("repeat");
                    } catch (SyntaxException eeee) {
                        revert();
                        
                        try {
                            expectString("for");
                        } catch (SyntaxException eeeee) {
                            revert();
                            
                            try {
                                expectString("get");
                            } catch (SyntaxException eeeeee) {
                                revert();
                                
                                SimpleExpression expr = new SimpleExpression(context);
                                
                                expectString("put_line");
                                expectString("(");
                                expr.execute();
                                expectString(")");
                                expectString(";");
                                
                                addInstruction(new WriteInstruction(expr.result));
                                addInstruction(new WritelnInstruction());
                            }
                            
                            
                            expectString("(");
                            var.execute();
                            expectString(")");
                            expectString(";");
                            
                            addInstruction(new ReadInstruction(var.var));
                            
                            return;
                        }
                        
                        throw new UnsupportedOperationException();
                        
                        //return;
                    }
                    
                    Marker m1, m2;
                    BooleanExpression expr;
                    
                    m1 = getMarker();
                    
                    new SentenceList(context).execute();
                    
                    expectString("until");
                    
                    expr = new BooleanExpression(context);
                    expr.execute();
                    
                    m2 = getMarker();
                    
                    completeGotos(expr.truelist, m2);
                    completeGotos(expr.falselist, m1);
                    
                    expectString("endrepeat");
                    expectString(";");
                    
                    return;
                }
                
                throw new UnsupportedOperationException();
                //return;
            }
            
            Marker m1, m2, m3, n;
            
            BooleanExpression expr = new BooleanExpression(context);
            expr.execute();
            
            m1 = getMarker();
            
            new SentenceList(context).execute();
            
            n = addInstruction(new GotoInstruction());
            
            expectString("else");
            m2 = getMarker();
            
            new SentenceList(context).execute();
            
            expectString("endif");
            expectString(";");
            m3 = getMarker();
            
            completeGotos(expr.truelist, m1);
            completeGotos(expr.falselist, m2);
            completeGoto(n, m3);
            
            return;
        }
        
        expectString(":=");
        
        SimpleExpression expr = new SimpleExpression(context);
        expr.execute();
        addInstruction(new AsignationInstruction(var.var, expr.result));
        
        expectString(";");
    }
    
}
