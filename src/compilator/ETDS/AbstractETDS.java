package compilator.ETDS;

import compilator.Token.*;
import compilator.*;
import compilator.Intermediate.*;
import compilator.Symbol.*;
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
    protected Token expectType (int type) throws SyntaxException {
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
    protected Token expectType(int type, boolean soft) throws SyntaxException {
        Token token;
        
        if (!context.tokenizer.hasMoreElements()) {
            throw new SyntaxException(null, TokenType.toString(type));
        }
        
        if (!context.reverted) {
            context.expectedList.clear();
        }
        
        context.reverted = false;
        
        context.expectedList.add(TokenType.toString(type));
        
        token = context.tokenizer.nextElement();
        
        if (!token.isType(type)) {
            if (soft) {
                throw new NoMatchException(token.getMatch(), context.expectedList);
            } else {
                throw new SyntaxException(token.getMatch(), context.expectedList);
            }
        }
        
        return token;
    }
    
    protected Token expectString(String str) throws SyntaxException {
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
    protected Token expectString(String str, boolean soft) throws SyntaxException {
        Token token;
        
        
        if (!context.tokenizer.hasMoreElements()) {
            throw new SyntaxException(null, str);
        }
        
        if (!context.reverted) {
            context.expectedList.clear();
        }
        
        context.reverted = false;
        
        context.expectedList.add(str);
        
        token = context.tokenizer.nextElement();
        
        
        if (!token.getMatch().equals(str)) {
            if (soft) {
                throw new NoMatchException(token.getMatch(), context.expectedList);
            } else {
                throw new SyntaxException(token.getMatch(), context.expectedList);
            }
        }
        
        return token;
    }
    
    /**
     * Se espera que ya no haya más tokens que analizar.
     * @throws SyntaxException Si no se ha llegado al final.
     */
    protected void expectEnd() throws SyntaxException {
        if (context.tokenizer.hasMoreElements()) {
            throw new SyntaxException(context.tokenizer.nextElement().getMatch(), "'fin de fichero'");
        }
    }
    
    /**
     * @see compilator.Token.Tokenizer#revert() 
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
    protected Symbol addSymbol(String name, int type) throws RedefinedSymbolException {
        Symbol symbol = new Symbol(name, type);
        context.symbolTable.add(symbol);
        return symbol;
    }
    
    /**
     * @see compilator.Symbol.SymbolTable#get(java.lang.String) 
     */
    protected Symbol getSymbol(String name) throws UndeclaredSymbolException {
        return context.symbolTable.get(name);
    }
    
    /**
     * @see compilator.Symbol.SymbolTable#createTemporary(int) 
     */
    protected Symbol getNewSymbol(int type) {
        return context.symbolTable.createTemporary(type);
    }
    
    /**
     * @see compilator.Intermediate.InstructionList#add(compilator.Intermediate.Instruction) 
     */
    protected Marker addInstruction(Instruction instruction) {
        return context.instructionList.add(instruction);
    }
    
    /**
     * @see compilator.Intermediate.InstructionList#getCurrentMarker() 
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
     * @see compilator.Symbol.SymbolTable#pushContext() 
     */
    protected void pushContext() {
        context.symbolTable.pushContext();
    }
    
    /**
     * @see compilator.Symbol.SymbolTable#popContext() 
     */
    protected void popContext() {
        context.symbolTable.popContext();
    }
}
