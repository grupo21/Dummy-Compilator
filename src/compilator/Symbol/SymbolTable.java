/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Symbol;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gmaiztegi
 */
public class SymbolTable {
    
    protected Map<String, Symbol> table;
    
    public SymbolTable() {
        this.table = new HashMap<String, Symbol>();
    }
    
    public void add(Symbol symbol) throws RedefinedSymbolException {
        
        if (table.containsKey(symbol.getName())) {
            throw new RedefinedSymbolException();
        }
        
        table.put(symbol.getName(), symbol);
    }
    
    public Symbol get(String name) throws UndeclaredSymbolException {
        Symbol symbol;
        
        symbol = table.get(name);
        
        if (symbol == null) {
            throw new UndeclaredSymbolException();
        }
        
        return symbol;
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
}
