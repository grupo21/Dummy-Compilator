package compiler.token;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;

/**
 * Clase que descompone la entrada en tokens
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Tokenizer {

    private StreamTokenizer tokenizer;
    private Token current;
    private Deque<Token> cola;

    /**
     * Inicializa el tokenizador con la entrada.
     * @param reader Entrada del código fuente.
     */
    public Tokenizer(Reader reader) throws IOException {
        tokenizer = new StreamTokenizer(reader);
        tokenizer.resetSyntax();
        tokenizer.wordChars('A', 'Z');
        tokenizer.wordChars('a', 'z');
        tokenizer.wordChars('0', '9');
        tokenizer.wordChars('_', '_');
        tokenizer.wordChars(':', ':');
        tokenizer.wordChars('<', '>');
        tokenizer.wordChars('.', '.');
        tokenizer.whitespaceChars('\u0000', '\u0020');
        tokenizer.lowerCaseMode(true);

        tokenizer.nextToken();

        cola = new LinkedList<Token>();
        current = null;
    }

    /**
     * Devuelve el último token encontrado sin avanzar.
     * @return El último Token devuelto
     */
    public Token getLookahead() throws Exception {
        if (current == null) {
            throw new Exception("No se puede obtener el actual tras revertir.");
        }

        return this.current;
    }

    public boolean hasMoreElements() {
        return !cola.isEmpty() || tokenizer.ttype != StreamTokenizer.TT_EOF;
    }

    public Token nextElement() throws IOException, LexicException {
        String match;
        int linenum;

        /**
         * Si ya había un token analizado anteriormente lo devolvemos y
         * eliminamos de la cola
         */
        if (!cola.isEmpty()) {
            current = cola.remove();
            return current;
        }

        while (skipComments());

        if (!cola.isEmpty()) {
            current = cola.remove();
            return current;
        }

        /*
         * El escáner devuelve la próxima palabra, utilizando espacios en blanco
         * como separador...
         */
        match = current();
        linenum = tokenizer.lineno();
        tokenizer.nextToken();

        /*
         * ... por lo que puede haber más de un token en esos caracteres,
         * por lo que analizamos para separarlo y añadir cada uno de los tokens
         * a la cola
         */
        while (match.length() > 0) {

            /**
             * Se inicializan los analizadores de expresiones regulares
             * para cada uno, pero no se ejecutan todavía.
             */
            Matcher idmatcher = Patterns.IDENT.matcher(match);
            Matcher floatmatcher = Patterns.FLOAT.matcher(match);
            Matcher intmatcher = Patterns.INTEGER.matcher(match);
            Matcher doublematcher = Patterns.SPECIALDOUBLE.matcher(match);
            Matcher specialmatcher = Patterns.SPECIALCHAR.matcher(match);

            /**
             * Se comprueba si coincide en el inicio con lookingAt(),
             * y si lo hace guarda los puntos de inicio y final.
             */
            if (idmatcher.lookingAt()) {
                /**
                 * Si es una palabra reservada se marca como tal.
                 */
                if (Token.isReserved(idmatcher.group())) {
                    /**
                     * Se guarda en la cola de tokens...
                     */
                    cola.add(new Token(idmatcher.group(), Token.RESERVED, linenum));
                } else {
                    cola.add(new Token(idmatcher.group(), Token.IDENTIFIER, linenum));
                }
                /**
                 * ... y se eliminan los carateres que han coincidido del string.
                 */
                match = match.substring(idmatcher.end());

            } else if (floatmatcher.lookingAt()) {
                cola.add(new FloatToken(floatmatcher.group(), linenum));
                match = match.substring(floatmatcher.end());

            } else if (intmatcher.lookingAt()) {
                cola.add(new IntegerToken(intmatcher.group(), linenum));
                match = match.substring(intmatcher.end());

            } else if (doublematcher.lookingAt()) {
                cola.add(new Token(doublematcher.group(), Token.SPECIALDOUBLE, linenum));
                match = match.substring(doublematcher.end());

            } else if (specialmatcher.lookingAt()) {
                cola.add(new Token(specialmatcher.group(), Token.SPECIALCHAR, linenum));
                match = match.substring(specialmatcher.end());

            } else {
                /**
                 * Si nada ha coincidido se sale del programa con un error.
                 */
                throw new LexicException("Error de léxico: carácter raro.");
            }
        }

        /**
         * Ahora devolvemos la primera ocurrencia.
         * Si sólo había una la cola quedará vacía.
         */
        this.current = cola.remove();

        while (skipComments());

        return this.current;
    }

    /**
     * Revierte el último token obtenido, para que este pueda ser obtenido otra vez.
     */
    public void revert() {

        if (current == null) {
            throw new RuntimeException("No se puede revertir si no hay un elemento todavía.");
        }

        cola.addFirst(current);
        current = null;
    }

    private boolean skipComments() throws IOException, LexicException {
        if (current().equals("{")) {
            cola.add(new Token("{", Token.SPECIALCHAR, tokenizer.lineno()));
            if (tokenizer.nextToken() != StreamTokenizer.TT_EOF && current().equals("*")) {
                cola.removeLast();

                while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                    boolean asteriscfound = false;
                    while (current().equals("*")) {
                        asteriscfound = true;
                        tokenizer.nextToken();
                    }
                    if (asteriscfound && current().equals("}")) {
                        tokenizer.nextToken();
                        return true;
                    }
                }

                throw new LexicException();
            }
        }

        return false;
    }

    private String current() {
        if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
            return tokenizer.sval;
            
        } else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
            return tokenizer.nval+"";
            
        } else {
            return new String(new char[] {(char) tokenizer.ttype});
        }
    }
}
