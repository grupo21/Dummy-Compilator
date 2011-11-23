/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator.Token;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gmaiztegi
 */
public class TokenType {
    
    public static final int RESERVED = 0;
    public static final int IDENTIFIER = 1;
    public static final int INTEGER = 2;
    public static final int FLOAT = 3;
    public static final int SPECIALDOUBLE = 4;
    public static final int SPECIALCHAR = 5;
    
    private static final String[] RESERVEDWORDS = {
        "var", "begin","endprogram", "program", "integer", "float", "procedure",
        "endprocedure", "is", "in", "out", "then", "if", "else", "endif",
        "repeat", "until", "endrepeat", "to", "for", "ascending", "descending",
        "from", "do", "endfor", "get", "put_line", "while", "endwhile"
    };
    
    public static final Set<String> RESERVEDSET = new HashSet<String>(Arrays.asList(RESERVEDWORDS));

    /**
     * Devuelve la representación en string del tipo num, para poder ser impreso
     * y hacer una traza.
     * @param num El identificador del tipo.
     * @return La representación en String del Tipo.
     */
    public static String toString(int tipo) {
        switch (tipo) {
            case RESERVED:
                return "reservada";
            case IDENTIFIER:
                return "identificador";
            case INTEGER:
                return "entero";
            case FLOAT:
                return "real";
            case SPECIALDOUBLE:
                return "especial doble";
            case SPECIALCHAR:
                return "caracter especial";
            default:
                return "desconocido";
        }
    }
    
    /**
     * Comprueba si el identificador id es una palabra reservada, utilizando
     * una tabla de todas las palabras reservadas.
     * @param id El identificador a analizar.
     * @return True si id es una palabra reservada, falso en caso contrario.
     */
    public static boolean isReserved(String id) {
        return RESERVEDSET.contains(id);
    }
}
