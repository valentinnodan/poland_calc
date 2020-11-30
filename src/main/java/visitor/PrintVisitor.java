package visitor;

import token.NumberToken;
import token.Token;
import token.brace.Brace;
import token.operation.Operation;

import java.io.PrintWriter;
import java.util.List;

import static java.util.Collections.reverse;

public class PrintVisitor implements TokenVisitor {

    PrintWriter pw;


    public void visit(List<Token> tokens, PrintWriter pw) {
        this.pw = pw;
        for (Token t : tokens) {
            t.accept(this);
            this.pw.print(" ");
        }
        this.pw.print(System.lineSeparator());
        this.pw.flush();
        this.pw = null;
    }

    @Override
    public void visit(NumberToken token) {
        pw.print(token.visualize());
    }

    @Override
    public void visit(Brace token) {
        pw.print(token.visualize());
    }

    @Override
    public void visit(Operation token) {
        pw.print(token.visualize());
    }
}
