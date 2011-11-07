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
    
    public void add(Symbol symbol) {
        
        if (table.containsKey(symbol.getName())) {
            throw new RedefinedSymbolException();
        }
        
        table.put(symbol.getName(), symbol);
    }
    
    public Symbol get(String name) {
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
    
    public int getType(String name) {
        return this.get(name).getType();
    }
    
    public boolean isType(String name, int type) {
        return type == this.get(name).getType();
    }
}
