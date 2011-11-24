package compilator.ETDS;

import compilator.*;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class SentenceList extends AbstractETDS {
    
    public SentenceList(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {
        try {
            new Sentence(context).execute();
            new SentenceList(context).execute();
        } catch (NoMatchException ex) {
            revert();
            return;
        }
    }
}
