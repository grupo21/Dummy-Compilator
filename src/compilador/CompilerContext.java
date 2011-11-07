/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import compiladorIntermediate.InstructionList;
import compilador.Token.Tokenizer;
import compilator.Symbol.SymbolTable;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author gmaiztegi
 */
public class CompilerContext {
    
    public Tokenizer tokenizer;
    public InstructionList instructionList;
    public SymbolTable symbolTable;
    
    public CompilerContext(Reader input, Writer output) {
        this.tokenizer = new Tokenizer(input);
        this.symbolTable = new SymbolTable();
        this.instructionList = new InstructionList();
    }
    
    public void compile() {
        
    }
    
    public void print() {
        
    }
}
