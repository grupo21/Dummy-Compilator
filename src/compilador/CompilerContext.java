/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import compilador.ETDS.*;
import compiladorIntermediate.InstructionList;
import compilador.Token.Tokenizer;
import compiladorIntermediate.Instruction;
import compilator.Symbol.SymbolTable;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;

/**
 *
 * @author gmaiztegi
 */
public class CompilerContext {
    
    public Tokenizer tokenizer;
    public InstructionList instructionList;
    public SymbolTable symbolTable;
    
    protected Writer output;
    
    public CompilerContext(Reader input, Writer output) {
        this.tokenizer = new Tokenizer(input);
        this.symbolTable = new SymbolTable();
        this.instructionList = new InstructionList();
        this.output = output;
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
        counter = 1;
        
        while(iter.hasNext()) {
            String instr = iter.next().getText();
            output.write(counter+"\t"+instr);
            counter++;
        }
    }
}
