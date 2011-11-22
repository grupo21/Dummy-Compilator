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

/**
 *
 * @author gmaiztegi
 */
public class CompilerContext {
    
    public Tokenizer tokenizer;
    public InstructionList instructionList;
    public SymbolTable symbolTable;
    
    protected PrintWriter output;
    
    public CompilerContext(Reader input, Writer output) {
        this.tokenizer = new Tokenizer(input);
        this.symbolTable = new SymbolTable();
        this.instructionList = new InstructionList();
        this.output = new PrintWriter(output, true);
    }
    
    public void compile() throws CompilerException {
        ETDS top;
        
        top = new Program(this);
        
        top.execute();
    }
    
    public void print() throws IOException {
        Iterator<Instruction> iter;
        int counter;
        
        iter = instructionList.iterator();
        counter = 0;
        
        while(iter.hasNext()) {
            Instruction instruction = iter.next();
            String instr = instruction.getText();
            output.println(counter+"\t"+instr);
            counter++;
        }
    }
}
