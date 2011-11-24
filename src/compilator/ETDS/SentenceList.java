/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.*;

/**
 *
 * @author gmaiztegi
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
