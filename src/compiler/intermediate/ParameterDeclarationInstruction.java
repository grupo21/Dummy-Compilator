package compiler.intermediate;

import compiler.symbol.Symbol;

/**
 * Instrucción que realiza una operación aritmética.
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class ParameterDeclarationInstruction extends DeclarationInstruction {
    
    protected boolean reference;
    
    /**
     * Deveuelve la representación en texto de referencia / valor.
     * @param reference Verdadero si es por referencia, falso si es por valor.
     * @return "val" si es por valor, "ref" si es por referencia.
     */
    public static String getRefValText(boolean reference) {
        return reference ? "ref" : "val";
    }
    
    /**
     * Construye la instrucción de declaración de un parámetro de un subprograma.
     * @param symbol Símbolo a declarar
     * @param reference Verdadero si se declara como referencia, falso en caso contrario.
     */
    public ParameterDeclarationInstruction(Symbol symbol, boolean reference) {
        super(symbol);
        
        this.reference = reference;
    }

    @Override
    public String getText() {
        return getRefValText(reference)+"_"+getTypeText(type)+" "+name+";";
    }
}
