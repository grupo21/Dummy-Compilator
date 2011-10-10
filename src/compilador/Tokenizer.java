package compilador;

import java.io.IOException;
import java.io.Reader;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Clase que descompone la entrada en tokens
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Tokenizer implements Enumeration {
    
    private Scanner scanner;
    private Token current;
    private Queue<Token> cola;
    
    public Tokenizer(Reader reader) {
        scanner = new Scanner(reader);
        cola = new LinkedList<Token>();
        current = null;
    }

    /**
     * Devuelve el último token encontrado sin avanzar.
     * @return El último Token devuelto
     */
    public Token getLookahead() {
        return this.current;
    }
    
    @Override
    public boolean hasMoreElements() {
        return !cola.isEmpty() || scanner.hasNext();
    }

    @Override
    public Token nextElement() throws NoSuchElementException {
        String match;
        
        /**
         * Si ya había un token analizado anteriormente lo devolvemos y
         * eliminamos de la cola
         */
        if (!cola.isEmpty()) {
            return cola.remove();
        }
        
        while (true) {
            try {
                /**
                 * Se quitan los espacios antes del comentario,
                 * Ya que el escáner no los quita con skip(), ...
                 */
                scanner.skip("\\s*");
                /**
                 * ...y después el comentario en sí...
                 */
                scanner.skip(Patterns.COMMENT);
                System.out.println("Comentario eliminado");
                
            /**
             * ... hasta que no haya más, donde salimos del bucle
             */
            } catch (NoSuchElementException e) {
                break;
            }
        }
        
        /*
         * El escáner devuelve la próxima palabra, utilizando espacios en blanco
         * como separador...
         */
        match = scanner.next();
        
        /*
         * ... por lo que puede haber más de un token en esos caracteres,
         * por lo que analizamos para separarlo y añadir cada uno de los tokens
         * a la cola
         */
        while (match.length()>0) {

            /**
             * Se inicializan los analizadores de expresiones regulares
             * para cada uno, pero no se ejecutan todavía.
             */
            Matcher idmatcher = Patterns.IDENT.matcher(match);
            Matcher floatmatcher = Patterns.FLOAT.matcher(match);
            Matcher intmatcher = Patterns.INTEGER.matcher(match);
            Matcher asignmatcher = Patterns.ASIGN.matcher(match);
            Matcher specialmatcher = Patterns.SPECIALCHAR.matcher(match);

            /**
             * Se comprueba si coincide en el inicio con lookingAt(),
             * y si lo hace guarda los puntos de inicio y final.
             */
            if (idmatcher.lookingAt()) {
                /**
                 * Si es una palabra reservada se marca como tal.
                 */
                if (TokenType.isReserved(match)) {
                    /**
                     * Se guarda en la cola de tokens...
                     */
                    cola.add(new Token(idmatcher.group(), TokenType.RESERVED));
                } else {
                    cola.add(new Token(idmatcher.group(), TokenType.IDENTIFIER));
                }
                /**
                 * ... y se eliminan los carateres que han coincidido del string.
                 */
                match = match.substring(idmatcher.end());

            } else if (floatmatcher.lookingAt()) {
                cola.add(new Token(floatmatcher.group(), TokenType.FLOAT));
                match = match.substring(floatmatcher.end());

            } else if (intmatcher.lookingAt()) {
                cola.add(new Token(intmatcher.group(), TokenType.INTEGER));
                match = match.substring(intmatcher.end());

            } else if (asignmatcher.lookingAt()) {
                cola.add(new Token(asignmatcher.group(), TokenType.ASIGN));
                match = match.substring(asignmatcher.end());

            } else if (specialmatcher.lookingAt()) {
                cola.add(new Token(specialmatcher.group(), TokenType.SPECIALCHAR));
                match = match.substring(specialmatcher.end());

            } else {
                /**
                 * Si nada ha coincidido se sale del programa con un error.
                 */
                System.out.flush();
                System.err.println("Error de lexico con "+match);
                System.exit(1);
            }
        }

        /**
         * Ahora devolvemos la primera ocurrencia.
         * Si sólo había una la cola quedará vacía.
         */
        this.current = cola.remove();
        
        return this.current;
    }
}
