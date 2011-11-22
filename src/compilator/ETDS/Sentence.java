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
                                
                                expectString("put_line");
                                
                                return;
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
            
            
            //return;
            
            throw new UnsupportedOperationException();
        }
        
        expectString(":=");
        
        SimpleExpression expr = new SimpleExpression(context);
        expr.execute();
        addInstruction(new AsignationInstruction(var.var, expr.result));
        
        expectString(";");
    }
    
}
