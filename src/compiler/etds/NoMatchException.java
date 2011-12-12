package compiler.etds;

import java.util.List;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class NoMatchException extends SyntaxException {
    
    public NoMatchException(SyntaxException ex) {
        super(ex);
    }
    
    public NoMatchException(String got, int lineGot, String expected) {
        super(got, lineGot, expected);
    }
    
    public NoMatchException(String got, int lineGot, List <String> expected) {
        super(got, lineGot, expected);
    }
}
