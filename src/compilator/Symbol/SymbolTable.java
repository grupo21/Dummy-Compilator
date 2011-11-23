/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Symbol;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author gmaiztegi
 */
public class SymbolTable implements Iterable<String> {
    
    protected Map<String, Symbol> table;
    protected Deque<String> context;
    protected int tempCounter, contextCounter;
    
    public SymbolTable() {
        this.table = new HashMap<String, Symbol>();
        context = new ArrayDeque<String>();
        context.push("");
        tempCounter = 0;
        contextCounter = 0;
    }
    
    public void add(Symbol symbol) throws RedefinedSymbolException {
        
        String fullname = getContext()+symbol.getName();
        
        if (table.containsKey(fullname)) {
            throw new RedefinedSymbolException();
        }
        
        table.put(fullname, symbol);
    }
    
    public Symbol get(String name) throws UndeclaredSymbolException {
        Symbol symbol;
        Iterator<String> iter;
        
        iter = context.descendingIterator();
        
        while (iter.hasNext()) {
            String fullname;
            fullname = iter.next()+name;
            symbol = table.get(fullname);
            
            if (symbol != null) {
                return symbol;
            }
        }
        
        throw new UndeclaredSymbolException();
    }
    
    public boolean exists(String name) {
        return table.containsKey(name);
    }
    
    public int getType(String name) throws UndeclaredSymbolException {
        return this.get(name).getType();
    }
    
    public boolean isType(String name, int type) throws UndeclaredSymbolException {
        return type == this.get(name).getType();
    }
    
    public Symbol createTemporary(int type) {
        int newId;
        Symbol temp;
        
        newId = tempCounter++;
        temp = new Symbol("_t"+newId, type);
        try {
            add(temp);
        } catch (RedefinedSymbolException ex) {
            System.err.print("Esto no debería haber pasado nunca");
            System.exit(1);
        }
        
        return temp;
    }
    
    public void pushContext() {
        String last, current;
        
        last = context.peek();
        
        current = last+(contextCounter++)+"__";
        
        context.push(current);
    }
    
    public void popContext() {
        context.pop();
    }
    
    protected String getContext() {
        return context.peek();
    }

    @Override
    public Iterator<String> iterator() {
        return table.keySet().iterator();
    }
}
