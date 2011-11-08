/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Symbol;

/**
 *
 * @author gmaiztegi
 */
public class Symbol {
    public static final int INTEGER = 0;
    public static final int FLOAT = 1;
    public static final int PROCEDURE = 2;
    public static final int FUNCTION = 3;
    public static final int PROGRAM = 4;
    
    protected String name;
    protected int type;
    
    public Symbol(String name, int type) {
        this.name = name;
        this.type = type;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getType() {
        return this.type;
    }
    
    public boolean isType(int type) {
        return type == this.type;
    }
}
