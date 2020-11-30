import token.Token;
import token.state.Tokenizer;
import visitor.CalcVisitor;
import visitor.ParserVisitor;
import visitor.PrintVisitor;

import java.io.PrintWriter;
import java.util.List;

public class Calc {
    public static void main(String[] args) {
        Tokenizer t = new Tokenizer();
        List<Token> l = t.tokenize("(30 + 2) / (8 + 0)");
        ParserVisitor p = new ParserVisitor();
        PrintVisitor printVisitor = new PrintVisitor();
        printVisitor.visit(l, new PrintWriter(System.out));

        List<Token> ll = p.visit(l);
        CalcVisitor cl = new CalcVisitor();
        printVisitor.visit(ll, new PrintWriter(System.out));
        System.out.println(cl.visit(ll));
    }
}
