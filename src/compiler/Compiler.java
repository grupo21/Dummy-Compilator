package compiler;

import java.io.*;

/**
 * Programa principal que ejecuta el compilador
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class Compiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InputStream instream;
        OutputStream outstream;
        Reader input;
        Writer output;
        
        CompilerContext context;


        if (args.length > 2) {
            System.err.println("Demasiados argumentos.");
            System.exit(1);
        }

        try {
            if (args.length > 0) {
                instream = new FileInputStream(args[0]);
            } else {
                instream = System.in;
            }

            if (args.length > 1) {
                outstream = new FileOutputStream(args[1]);
            } else {
                outstream = System.out;
            }
            
            input = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
            output = new BufferedWriter(new OutputStreamWriter(outstream, "UTF-8"));
            System.setErr(new PrintStream(System.err, true, "UTF-8"));

            context = new CompilerContext(input, output);

            context.compile();
            context.print();

        } catch (FileNotFoundException ex) {
            System.err.println("Error al abrir la entrada: " + ex.getLocalizedMessage());
            System.exit(1);
        } catch (UnsupportedEncodingException ex) {
            System.err.println("No se ha podido cambiar la codificacion: "
                    + ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.err.println("Error al escribir el código: " + ex.getLocalizedMessage());
            System.exit(1);
        } catch (CompilerException ex) {
            System.err.println("Error de compilación: " + ex.getMessage());
            System.exit(1);
        }
    }
}
