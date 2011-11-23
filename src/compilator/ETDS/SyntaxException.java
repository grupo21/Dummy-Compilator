/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.CompilerException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gmaiztegi
 */
public class SyntaxException extends CompilerException {
    
    protected List<String> expected;
    protected String got;
    
    public SyntaxException(String got, String expected) {
        this.got = got;
        this.expected = new LinkedList<String>();
        this.expected.add(expected);
    }
    
    public SyntaxException(String got, List <String> expected) {
        this.got = got;
        this.expected = expected;
    }

    @Override
    public String getMessage() {
        String msg;
        
        
        if (expected == null) {
            return "Se esperaba fin de fichero, se ha obtenido \""+got+"\"";
        } else if (got == null) {
            return "Se esperaba \""+got+"\", se ha obtenido fin de fichero.";
        }
        
        msg = "Se ha obtenido \""+got+"\", se esperaba: ";
        
        for (String exp : expected) {
            msg += exp+" ";
        }
        
        return msg;
    }
}
