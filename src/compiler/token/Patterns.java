/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.token;

import java.util.regex.Pattern;

/**
 * Clase contenedora de las expresiones regulares del analizador léxico
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Patterns {
    
    public static final Pattern INTEGER = Pattern.compile("[0-9]+");
    public static final Pattern FLOAT = Pattern.compile("[0-9]+\\.[0-9]+([eE][+-]?[0-9]+)?");
    public static final Pattern COMMENT = Pattern.compile("\\{\\*([^*]|(\\*+[^*}]))*\\*+\\}", Pattern.MULTILINE);
    public static final Pattern IDENT = Pattern.compile("[a-zA-Z](_?[a-zA-Z0-9])*");
    public static final Pattern SPECIALDOUBLE = Pattern.compile("(:=|<=|>=)");
    public static final Pattern SPECIALCHAR = Pattern.compile("[-+*/()\\\\:,;$%&|~{}<>\\[\\]=\\^.]");
}
