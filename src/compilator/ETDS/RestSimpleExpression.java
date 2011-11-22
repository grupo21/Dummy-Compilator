/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.CompilerContext;
import compilator.CompilerException;
import compilator.Intermediate.OperationInstruction;
import compilator.Symbol.Symbol;

/**
 *
 * @author gmaiztegi
 */
class RestSimpleExpression extends AbstractETDS {
    
    public Symbol hsymbol;
    public Symbol result;
    
    public RestSimpleExpression(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        
        Term term;
        String operation = null;
        
        try {
            expectString("+");
            operation = "+";
        } catch (SyntaxException e) {
            revert();
            
            try {
                expectString("-");
                operation = "-";
            } catch (SyntaxException ex) {
                revert();
                result = hsymbol;
                return;
            }
        }
        
        term = new Term(context);
        term.execute();
        
        result = getNewSymbol(hsymbol.getType());
        
        addInstruction(new OperationInstruction(result, hsymbol, term.result, operation));
    }
    
}