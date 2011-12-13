package compiler.token;

import java.util.*;

/**
 * Clase que representa a un Token y su información
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Token implements Cloneable {
    
    
    public static final int RESERVED = 0;
    public static final int IDENTIFIER = 1;
    public static final int INTEGER = 2;
    public static final int FLOAT = 3;
    public static final int SPECIALDOUBLE = 4;
    public static final int SPECIALCHAR = 5;
    
    public static final Set<String> RESERVEDWORDS =
            new HashSet<String>(Arrays.asList(new String[] {"var", "begin","endprogram", "program", "integer", "float", "procedure",
        "endprocedure", "is", "in", "out", "then", "if", "else", "endif",
        "repeat", "until", "endrepeat", "to", "for", "ascending", "descending",
        "from", "do", "endfor", "get", "put_line", "while", "endwhile"}));

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
        return RESERVEDWORDS.contains(id);
    }
    
    private String match;
    private int type, linenum;
    
    /**
     * Construye un token con la cadena casada y el tipo.
     * @param match Cadena de caracteres que componen el Token
     * @param type Identificador del tipo de token
     */
    public Token(String match, int type, int linenum)
    {
        this.match = match;
        this.type = type;
        this.linenum = linenum;
    }
    
    /**
     * Devuelve la cadena de caracteres que ha casado.
     * @return La cadena de caracteres del token.
     */
    public String getMatch() {
        return match;
    }
    
    /**
     * Devuelve información detallada acerca del token.
     * @return Cadena imprimible para debug.
     */
    public String getInfo()
    {
        return match + "\t\t" + toString(type);
    }
    
    /**
     * Devuelve el tipo de token.
     * @return Tipo de token.
     */
    public int getType() {
        return type;
    }
    
    /**
     * Comprueba que el token sea del tipo indicado
     * @param type Identificador del tipo de token
     * @return Verdadero si los tipos son iguales, falso en caso contrario
     */
    public Boolean isType(int type)
    {
        return this.type == type;
    }
    
    /**
     * Devuelve el número de línea en el que se encontraba el token.
     * @return El número de línea.
     */
    public int getLineNumber() {
        return linenum;
    }
}
