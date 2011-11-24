package compilator.ETDS;

import compilator.*;
import compilator.Intermediate.*;
import compilator.Symbol.Symbol;

/**
 * @author Jon Aguirre <jaguirre026@ehu.es>
 * @author Ander Arbelaitz <aarbelaiz004@ehu.es>
 * @author Gorka Maiztegi <gmaiztegi001@ehu.es>
 */
class Sentence extends AbstractETDS {

    public Sentence(CompilerContext context) {
        super(context);
    }

    @Override
    public void execute() throws CompilerException {

        try {
            Variable var = new Variable(context);
            
            var.execute();

            expectString(":=");

            SimpleExpression expr = new SimpleExpression(context);
            expr.execute();
            addInstruction(new AsignationInstruction(var.var, expr.result));

            expectString(";");
            
            return;

        } catch (NoMatchException e) {
            revert();
        }

        try {
            expectString("if", true);

            Marker m1, m2, m3, n;

            BooleanExpression expr = new BooleanExpression(context);
            expr.execute();

            m1 = getMarker();

            new SentenceList(context).execute();

            n = addInstruction(new GotoInstruction());

            expectString("else");
            m2 = getMarker();

            new SentenceList(context).execute();

            expectString("endif");
            expectString(";");
            m3 = getMarker();

            completeGotos(expr.truelist, m1);
            completeGotos(expr.falselist, m2);
            completeGoto(n, m3);
            
            return;
            
        } catch (NoMatchException ee) {
            revert();
        }

        try {
            expectString("while", true);
            Marker m1, m2, m3, n;
            BooleanExpression expr = new BooleanExpression(context);

            m1 = getMarker();
            expr.execute();
            expectString("do");
            m2 = getMarker();
            new SentenceList(context).execute();

            n = addInstruction(new GotoInstruction(m1));

            expectString("endwhile");
            expectString(";");

            m3 = getMarker();

            completeGotos(expr.truelist, m2);
            completeGotos(expr.falselist, m3);

            return;

        } catch (NoMatchException eee) {
            revert();
        }
        try {
            expectString("repeat", true);

            Marker m1, m2;
            BooleanExpression expr;

            m1 = getMarker();

            new SentenceList(context).execute();

            expectString("until");

            expr = new BooleanExpression(context);
            expr.execute();

            m2 = getMarker();

            completeGotos(expr.truelist, m2);
            completeGotos(expr.falselist, m1);

            expectString("endrepeat");
            expectString(";");
            
            return;

        } catch (NoMatchException eeee) {
            revert();
        }

        try {
            expectString("for", true);

            ForMode mode;
            SimpleExpression ex1, ex2;
            Marker m1, m2;
            Variable var;

            mode = new ForMode(context);
            ex1 = new SimpleExpression(context);
            ex2 = new SimpleExpression(context);
            var = new Variable(context);

            var.execute();
            mode.execute();
            expectString("from");
            ex1.execute();
            expectString("to");
            ex2.execute();
            expectString("do");

            addInstruction(new AsignationInstruction(var.var, ex1.result));

            if (mode.ascending) {
                m1 = addInstruction(new IfGotoInstruction(var.var, ex2.result, ">"));
            } else {
                m1 = addInstruction(new IfGotoInstruction(var.var, ex2.result, "<"));
            }

            new SentenceList(context).execute();

            expectString("endfor");
            expectString(";");

            m2 = getMarker();

            if (mode.ascending) {
                addInstruction(new OperationInstruction(var.var, var.var, new Symbol("1", Symbol.INTEGER), "+"));
            } else {
                addInstruction(new OperationInstruction(var.var, var.var, new Symbol("1", Symbol.INTEGER), "-"));
            }

            addInstruction(new GotoInstruction(m1));

            completeGoto(m1, m2.add(2));
            
            return;

        } catch (NoMatchException eeeee) {
            revert();
        }

        try {
            Variable var;
            
            expectString("get", true);
            
            var = new Variable(context);
            
            expectString("(");
            var.execute();
            expectString(")");
            expectString(";");

            addInstruction(new ReadInstruction(var.var));
            
            return;

        } catch (NoMatchException eeeeee) {
            revert();
        }

        try {
            SimpleExpression expr = new SimpleExpression(context);

            expectString("put_line", true);
            expectString("(");
            expr.execute();
            expectString(")");
            expectString(";");

            addInstruction(new WriteInstruction(expr.result));
            addInstruction(new WritelnInstruction());
            
            return;
            
        } catch (NoMatchException ex) {
            throw ex;
        }
        
    }
}
