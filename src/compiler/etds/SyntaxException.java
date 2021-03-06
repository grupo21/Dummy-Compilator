package compiler.etds;

import compiler.CompilerException;
import java.util.LinkedList;
import java.util.List;

/**
 * Señaliza un error de sintaxis en el código fuente.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class SyntaxException extends CompilerException {
    
    protected List<String> expected;
    protected String got;
    protected int lineGot;
    
    public SyntaxException(SyntaxException ex) {
        this(ex.got, ex.lineGot, ex.expected);
    }
    
    public SyntaxException(String got, int lineGot, String expected) {
        this.got = got;
        this.lineGot = lineGot;
        this.expected = new LinkedList<String>();
        this.expected.add(expected);
    }
    
    public SyntaxException(String got, int lineGot, List <String> expected) {
        this.got = got;
        this.lineGot = lineGot;
        this.expected = new LinkedList<String>(expected);
    }

    @Override
    public String getMessage() {
        String msg;
        
        
        if (expected == null) {
            return "Se esperaba fin de fichero, se ha obtenido \""+got
                    +"\" en la línea "+lineGot+".";
        } else if (got == null) {
            return "Se esperaba \""+got+"\", se ha obtenido fin de fichero.";
        }
        
        msg = "Se ha obtenido \""+got+"\" en la línea "+lineGot+", se esperaba: ";
        
        for (String exp : expected) {
            msg += exp+" ";
        }
        
        return msg;
    }
}
