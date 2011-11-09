/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ETDS;

import compilador.Token.*;
import compilador.*;
import compiladorIntermediate.*;
import compilator.Symbol.*;

/**
 * Token representando un flotante
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public abstract class AbstractETDS implements ETDS {
    
    protected CompilerContext context;
    
    public AbstractETDS(CompilerContext context) {
        this.context = context;
    }
    
    public Token expectType(int type) throws SyntaxException {
        Token token;
        
        if (!context.tokenizer.hasMoreElements()) {
            throw new SyntaxException("Se esperaba token del tipo "+TokenType.toString(type)+" pero el archivo se ha acabado.");
        }
        
        token = context.tokenizer.nextElement();
        
        if (!token.isType(type)) {
            throw new SyntaxException("Se esperaba token del tipo "+TokenType.toString(type)+" pero se ha encontrado "+TokenType.toString(token.getType()));
        }
        
        return token;
    }
    
    public Token expectString(String str) throws SyntaxException {
        Token token;
        
        
        if (!context.tokenizer.hasMoreElements()) {
            throw new SyntaxException("Se esperaba \""+str+"\", se ha obtenido fin de archivo.");
        }
        
        token = context.tokenizer.nextElement();
        
        if (!token.getMatch().equals(str)) {
            throw new SyntaxException("Se esperaba \""+str+"\", se ha obtenido \""+token.getMatch()+"\".");
        }
        
        return token;
    }
    
    public void revert() {
        context.tokenizer.revert();
    }
    
    public Symbol addSymbol(String name, int type) throws RedefinedSymbolException {
        Symbol symbol = new Symbol(name, type);
        context.symbolTable.add(symbol);
        return symbol;
    }
    
    public Marker addInstruction(Instruction instruction) {
        return context.instructionList.add(instruction);
    }
    
    public Marker getMarker() {
        return context.instructionList.getCurrentMarker();
    }
}
