/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public static void main(String[] args) throws CompilerException, IOException {
        
        Reader input = null;
        Writer output;
        CompilerContext context;
        
        if (args.length > 0) {
            try {
                input = new BufferedReader(new FileReader(args[0]));
            } catch (FileNotFoundException ex) {
                System.err.println("Error al abrir la entrada: "+ex.getLocalizedMessage());
                System.exit(1);
            }
        } else {
            input = new BufferedReader(new InputStreamReader(System.in));
        }
        
        output = new BufferedWriter(new OutputStreamWriter(System.out));

        context = new CompilerContext(input, output);
        
        try {
            context.compile();
        } catch (CompilerException ex) {
            context.print();
            throw ex;
        }
        
        context.print();
    }
}
