package compilator.Intermediate;

import compilator.Symbol.Symbol;

/**
 * Instrucción de declaración de una variable.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class DeclarationInstruction implements Instruction {
    
    protected String name;
    protected int type;
    
    /**
     * Devuelve la representación en texto del tipo de variable.
     * @param type El tipo de variable.
     * @return La representación en texto de type.
     */
    public static String getTypeText(int type) {
        switch (type) {
            case Symbol.INTEGER:
                return "int";
            case Symbol.FLOAT:
                return "real";
            default:
                throw new IllegalArgumentException();
        }
    }
    
    /**
     * Construye una instrucción que declara una variable
     * @param symbol El símbolo a declarar.
     */
    public DeclarationInstruction(Symbol symbol) {
        if (!symbol.isType(Symbol.INTEGER) && !symbol.isType(Symbol.FLOAT)) {
            throw new IllegalArgumentException();
        }
        
        this.name = symbol.getName();
        this.type = symbol.getType();
    }

    @Override
    public String getText() {
        return getTypeText(this.type)+" "+this.name+";";
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
