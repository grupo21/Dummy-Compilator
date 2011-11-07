/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import compilador.Token.Tokenizer;
import compilador.ETDS.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        BufferedReader buffer = null;
        Tokenizer tokenizer;
        AbstractETDS program;
        
        if (args.length > 0) {
            try {
                buffer = new BufferedReader(new FileReader(args[0]));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        } else {
            buffer = new BufferedReader(new InputStreamReader(System.in));
        }

        tokenizer = new Tokenizer(buffer);
        program = new Program();
        program.execute(null);
    }
}
