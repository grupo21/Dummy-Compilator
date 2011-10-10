/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gmaiztegi
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader buffer = null;
        Tokenizer tokenizer;
        
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
        while (tokenizer.hasMoreElements()) {
            Token token = tokenizer.nextElement();
            token.printInfo();
        }
    }
}
