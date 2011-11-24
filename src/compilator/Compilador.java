package compilator;

import java.io.*;

/**
 * Programa de prueba para el analizador léxico
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Reader input = null;
        Writer output = null;
        CompilerContext context;
        
        try {
            System.setErr(new PrintStream(System.err, true, "UTF-8"));
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.err.println("No se ha podido cambiar la codificacion: "
                    + ex.getLocalizedMessage());
        }
        
        if (args.length > 2) {
            System.err.println("Demasiados argumentos.");
            System.exit(1);
        }
        

        if (args.length > 0) {
            try {
                input = new BufferedReader(new FileReader(args[0]));
            } catch (FileNotFoundException ex) {
                System.err.println("Error al abrir la entrada: " + ex.getLocalizedMessage());
                System.exit(1);
            }
        } else {
            input = new BufferedReader(new InputStreamReader(System.in));
        }
        
        if (args.length > 1) {
            try {
                output = new BufferedWriter(new FileWriter(args[1]));
            } catch (IOException ex) {
                System.err.println("Error al crear la salida: " + ex.getLocalizedMessage());
                System.exit(1);
            }
        } else {
            output = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        context = new CompilerContext(input, output);

        try {
            context.compile();

            try {
                context.print();
            } catch (IOException ex) {
                System.err.println("Error al escribir el código: " + ex.getLocalizedMessage());
                System.exit(1);
            }
        } catch (CompilerException ex) {
            System.err.println("Error de compilación: "+ex.getMessage());
                System.exit(1);
        }

    }
}
