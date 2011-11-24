package compiler;

import compiler.etds.*;
import compiler.intermediate.*;
import compiler.token.Tokenizer;
import compiler.symbol.SymbolTable;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Contexto de compilación, que contiene las variables globales
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public class CompilerContext {
    
    public Tokenizer tokenizer;
    public InstructionList instructionList;
    public SymbolTable symbolTable;
    
    public List<String> expectedList;
    public boolean reverted;
    
    protected PrintWriter output;
    
    /**
     * Construye el contexto de compilación
     * @param input La entrada del programa fuente
     * @param output La salida para el código intermedio
     */
    public CompilerContext(Reader input, Writer output) {
        this.tokenizer = new Tokenizer(input);
        this.symbolTable = new SymbolTable();
        this.instructionList = new InstructionList();
        this.expectedList = new LinkedList<String>();
        this.reverted = false;
        this.output = new PrintWriter(output, true);
    }
    
    /**
     * Compila todo el código fuente.
     * @throws CompilerException si ha habido cualquier tipo de error de compilación.
     */
    public void compile() throws CompilerException {
        ETDS top;
        
        top = new Program(this);
        
        top.execute();
    }
    
    /**
     * Imprime el código intermedio por la salida
     * @throws IOException si hay algún error al imprimir el código
     */
    public void print() throws IOException {
        int counter = 0;
        
        for (Instruction instr : instructionList) {
            output.println(counter+"\t"+instr.getText());
            counter++;
        }
    }
}
