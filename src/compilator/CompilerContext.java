/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator;

import compilator.ETDS.*;
import compilator.Intermediate.InstructionList;
import compilator.Token.Tokenizer;
import compilator.Intermediate.Instruction;
import compilator.Symbol.SymbolTable;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gmaiztegi
 */
public class CompilerContext {
    
    public Tokenizer tokenizer;
    public InstructionList instructionList;
    public SymbolTable symbolTable;
    
    public List<String> expectedList;
    public boolean reverted;
    
    protected PrintWriter output;
    
    public CompilerContext(Reader input, Writer output) {
        this.tokenizer = new Tokenizer(input);
        this.symbolTable = new SymbolTable();
        this.instructionList = new InstructionList();
        this.expectedList = new LinkedList<String>();
        this.reverted = false;
        this.output = new PrintWriter(output, true);
    }
    
    public void compile() throws CompilerException {
        ETDS top;
        
        top = new Program(this);
        
        top.execute();
    }
    
    public void print() throws IOException {
        int counter = 0;
        
        for (Instruction instr : instructionList) {
            output.println(counter+"\t"+instr.getText());
            counter++;
        }
    }
}
