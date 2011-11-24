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
    
    protected Token expectType (int type) throws SyntaxException {
        return expectType(type, false);
    }
    
    protected Token expectType(int type, boolean soft) throws SyntaxException {
        Token token;
        
        if (!context.tokenizer.hasMoreElements()) {
            throw new SyntaxException(null, TokenType.toString(type));
        }
        
        if (!context.reverted) {
            context.expectedList.clear();
        }
        
        context.reverted = false;
        
        context.expectedList.add(TokenType.toString(type));
        
        token = context.tokenizer.nextElement();
        
        if (!token.isType(type)) {
            if (soft) {
                throw new NoMatchException(token.getMatch(), context.expectedList);
            } else {
                throw new SyntaxException(token.getMatch(), context.expectedList);
            }
        }
        
        return token;
    }
    
    protected Token expectString(String str) throws SyntaxException {
        return expectString(str, false);
    }
    
    protected Token expectString(String str, boolean soft) throws SyntaxException {
        Token token;
        
        
        if (!context.tokenizer.hasMoreElements()) {
            throw new SyntaxException(null, str);
        }
        
        if (!context.reverted) {
            context.expectedList.clear();
        }
        
        context.reverted = false;
        
        context.expectedList.add(str);
        
        token = context.tokenizer.nextElement();
        
        
        if (!token.getMatch().equals(str)) {
            if (soft) {
                throw new NoMatchException(token.getMatch(), context.expectedList);
            } else {
                throw new SyntaxException(token.getMatch(), context.expectedList);
            }
        }
        
        return token;
    }
    
    protected void expectEnd() throws SyntaxException {
        if (context.tokenizer.hasMoreElements()) {
            throw new SyntaxException(context.tokenizer.nextElement().getMatch(), "'fin de fichero'");
        }
    }
    
    protected void revert() {
        context.reverted = true;
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
    
    protected void pushContext() {
        context.symbolTable.pushContext();
    }
    
    protected void popContext() {
        context.symbolTable.popContext();
    }
}
