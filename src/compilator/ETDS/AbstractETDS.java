/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.ETDS;

import compilator.Token.*;
import compilator.*;
import compilator.Intermediate.*;
import compilator.Symbol.*;
import java.util.Iterator;
import java.util.List;

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
    
    protected Token expectType(int type) throws SyntaxException {
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
    
    protected Token expectString(String str) throws SyntaxException {
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
    
    protected void revert() {
        context.tokenizer.revert();
    }
    
    protected Symbol addSymbol(String name, int type) throws RedefinedSymbolException {
        Symbol symbol = new Symbol(name, type);
        context.symbolTable.add(symbol);
        return symbol;
    }
    
    protected Symbol getSymbol(String name) throws UndeclaredSymbolException {
        return context.symbolTable.get(name);
    }
    
    protected Symbol getNewSymbol(int type) {
        return context.symbolTable.createTemporary(type);
    }
    
    protected Marker addInstruction(Instruction instruction) {
        return context.instructionList.add(instruction);
    }
    
    protected Marker getMarker() {
        return context.instructionList.getCurrentMarker();
    }
    
    protected void completeGoto(Marker from, Marker to) {
        CompletableInstruction inst;
        
        inst = (CompletableInstruction)context.instructionList.get(from);
        
        inst.complete(to);
    }
    
    protected void completeGotos(List<Marker> list, Marker where) {
        Iterator<Marker> iter;
        
        iter = list.iterator();
        
        while (iter.hasNext()) {
            completeGoto(iter.next(), where);
        }
    }
}
