package compiler.symbol;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Representación de la tabla de símbolos.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class SymbolTable implements Iterable<String> {
    
    protected Map<String, Symbol> table;
    protected Deque<String> context;
    protected int tempCounter, contextCounter;
    
    /**
     * Inicializa la tabla de símbolos
     */
    public SymbolTable() {
        this.table = new HashMap<String, Symbol>();
        context = new ArrayDeque<String>();
        context.push("");
        tempCounter = 0;
        contextCounter = 0;
    }
    
    /**
     * Añade la variable a la tabla de símbolos con el contexto actual.
     * @param symbol El símbolo a añadir.
     * @throws RedefinedSymbolException si la variable ya estaba definida.
     */
    public void add(Symbol symbol) throws RedefinedSymbolException {
        
        String fullname = getContext()+symbol.getName();
        
        if (table.containsKey(fullname)) {
            Symbol previous = table.get(fullname);
            throw new RedefinedSymbolException(symbol.getName(), previous.getLineNum(), symbol.getLineNum());
        }
        
        table.put(fullname, symbol);
    }
    
    /**
     * Obtiene la variable mediante su identificador.
     * @param name El identificador de la variable.
     * @return El símbolo de la variable, si este se ha encontrado.
     * @throws UndeclaredSymbolException si el identificador no se encuentra en la tabla.
     */
    public Symbol get(String name, int lineNum) throws UndeclaredSymbolException {
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
        
        throw new UndeclaredSymbolException(name, lineNum);
    }
    
    /**
     * Crea una variable temporal en el contexto actual.
     * @param type El tipo del que la variable temporal debe ser.
     * @return La variable temporal recién creada.
     */
    public Symbol createTemporary(int type) {
        int newId;
        Symbol temp;
        
        newId = tempCounter++;
        temp = new Symbol("_t"+newId, type, -1);
        try {
            add(temp);
        } catch (RedefinedSymbolException ex) {
            throw new RuntimeException(ex);
        }
        
        return temp;
    }
    
    /**
     * Empila un nuevo contexto a la pila de contextos.
     */
    public void pushContext() {
        String last, current;
        
        last = context.peek();
        
        current = last+(contextCounter++)+"__";
        
        context.push(current);
    }
    
    /**
     * Desempila el contexto superior.
     */
    public void popContext() {
        context.pop();
    }
    
    /**
     * Devuelve el contexto actual.
     * @return El prefijo del contexto actual.
     */
    protected String getContext() {
        return context.peek();
    }

    @Override
    public Iterator<String> iterator() {
        return table.keySet().iterator();
    }
}
