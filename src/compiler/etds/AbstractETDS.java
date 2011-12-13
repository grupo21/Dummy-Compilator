package compiler.etds;

import compiler.token.*;
import compiler.*;
import compiler.intermediate.*;
import compiler.symbol.*;
import java.io.IOException;
import java.util.List;

/**
 * Clase abstracta que implementa funciones de ayuda para un ETDS
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
public abstract class AbstractETDS implements ETDS {
    
    protected CompilerContext context;
    
    /**
     * Construye el ETDS
     * @param context El contexto global de compilación.
     */
    public AbstractETDS(CompilerContext context) {
        this.context = context;
    }
    
    /**
     * Se espera un token del tipo type.
     * @param type El tipo de token esperado.
     * @return El token obtenido.
     * @throws SyntaxException Si el token obtenido no era del tipo esperado.
     */
    protected Token expectType (int type) throws SyntaxException, LexicException {
        return expectType(type, false);
    }
    
    /**
     * Se espera y obtiene un token del tipo type
     * @param type El tipo de token esperado
     * @param soft El valor verdadero significa que se contempla la posibilidad de que no sea el esperado.
     * @return El token obtenido.
     * @throws SyntaxException Si el token obtenido no era del tipo esperado.
     * @throws NoMatchException Si el token no era el esperado, pero soft era verdadero.
     */
    protected Token expectType(int type, boolean soft) throws SyntaxException, LexicException {
        Token token;
        
        if (!context.tokenizer.hasMoreElements()) {
            throw new SyntaxException(null, 0, TokenType.toString(type));
        }
        
        if (!context.reverted) {
            context.expectedList.clear();
        }
        
        context.reverted = false;
        
        context.expectedList.add(TokenType.toString(type));
        
        try {
            token = context.tokenizer.nextElement();
        } catch (IOException ex) {
            throw new LexicException("Error de entrada: "+ex.getLocalizedMessage());
        }
        
        if (!token.isType(type)) {
            if (soft) {
                throw new NoMatchException(token.getMatch(), token.getLineNumber(), context.expectedList);
            } else {
                throw new SyntaxException(token.getMatch(), token.getLineNumber(), context.expectedList);
            }
        }
        
        return token;
    }
    
    protected Token expectString(String str) throws SyntaxException, LexicException {
        return expectString(str, false);
    }
    
    /**
     * Se espera y obtiene un token igual a str
     * @param str La cadena esperada
     * @param soft El valor verdadero significa que se contempla la posibilidad de que no sea el esperado.
     * @return El token obtenido.
     * @throws SyntaxException Si el token obtenido no era el esperado.
     * @throws NoMatchException Si el token no era el esperado, pero soft era verdadero.
     */
    protected Token expectString(String str, boolean soft) throws SyntaxException, LexicException {
        Token token;
        
        
        if (!context.tokenizer.hasMoreElements()) {
            throw new SyntaxException(null, 0, str);
        }
        
        if (!context.reverted) {
            context.expectedList.clear();
        }
        
        context.reverted = false;
        
        context.expectedList.add(str);
        
        try {
            token = context.tokenizer.nextElement();
        } catch (IOException ex) {
            throw new LexicException("Error de entrada: "+ex.getLocalizedMessage());
        }
        
        if (!token.getMatch().equals(str)) {
            if (soft) {
                throw new NoMatchException(token.getMatch(), token.getLineNumber(), context.expectedList);
            } else {
                throw new SyntaxException(token.getMatch(), token.getLineNumber(), context.expectedList);
            }
        }
        
        return token;
    }
    
    /**
     * Se espera que ya no haya más tokens que analizar.
     * @throws SyntaxException Si no se ha llegado al final.
     */
    protected void expectEnd() throws SyntaxException, LexicException {
        if (context.tokenizer.hasMoreElements()) {
            try {
                Token token = context.tokenizer.nextElement();
                throw new SyntaxException(context.tokenizer.nextElement().getMatch(), context.tokenizer.nextElement().getLineNumber(), "'fin de fichero'");
            } catch (IOException ex) {
                throw new LexicException("Error de entrada: "+ex.getLocalizedMessage());
            }
        }
    }
    
    /**
     * @see compiler.token.Tokenizer#revert() 
     */
    protected void revert() {
        context.reverted = true;
        context.tokenizer.revert();
    }
    
    /**
     * Crea y añade un símbolo a la tabla de símbolos.
     * @param name El identificador del nuevo símbolo.
     * @param type El tipo del símbolo a crear.
     * @return El símbolo recién creado.
     * @throws RedefinedSymbolException si el símbolo ya estaba definido en el contexto actual.
     */
    protected Symbol addSymbol(Token token, int type) throws RedefinedSymbolException {
        Symbol symbol = new Symbol(token.getMatch(), type, token.getLineNumber());
        context.symbolTable.add(symbol);
        return symbol;
    }
    
    /**
     * @see compiler.symbol.SymbolTable#get(java.lang.String) 
     */
    protected Symbol getSymbol(String name) throws UndeclaredSymbolException {
        return context.symbolTable.get(name);
    }
    
    /**
     * @see compiler.symbol.SymbolTable#createTemporary(int) 
     */
    protected Symbol getNewSymbol(int type) {
        return context.symbolTable.createTemporary(type);
    }
    
    /**
     * @see compiler.intermediate.InstructionList#add(compiler.intermediate.Instruction) 
     */
    protected Marker addInstruction(Instruction instruction) {
        return context.instructionList.add(instruction);
    }
    
    /**
     * @see compiler.intermediate.InstructionList#getCurrentMarker() 
     */
    protected Marker getMarker() {
        return context.instructionList.getCurrentMarker();
    }
    
    /**
     * Completa la instrucción incompleta referenciada por from con la referencia to.
     * @param from La instrucción incompleta a completar.
     * @param to La referencia al lugar donde form debe saltar.
     */
    protected void completeGoto(Marker from, Marker to) {
        CompletableInstruction inst;
        
        inst = (CompletableInstruction)context.instructionList.get(from);
        
        inst.complete(to);
    }
    
    /**
     * Completa todas las instrucciónes referenciadas en list con la referencia where
     * @param list La lista de referencias a las instrucciones incompletas.
     * @param to 
     */
    protected void completeGotos(List<Marker> list, Marker to) {
        for (Marker marker : list) {
            completeGoto(marker, to);
        }
    }
    
    /**
     * @see compiler.symbol.SymbolTable#pushContext() 
     */
    protected void pushContext() {
        context.symbolTable.pushContext();
    }
    
    /**
     * @see compiler.symbol.SymbolTable#popContext() 
     */
    protected void popContext() {
        context.symbolTable.popContext();
    }
}
