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
        List<Token> l = t.tokenize("3 * (32 + 5) * (10 - 4 * 5)");
        ParserVisitor p = new ParserVisitor();
        PrintVisitor printVisitor = new PrintVisitor();
        printVisitor.visit(l, new PrintWriter(System.out));

        p.visit(l);
        List<Token> ll = p.getRes();
        CalcVisitor cl = new CalcVisitor();
        printVisitor.visit(ll, new PrintWriter(System.out));
        cl.visit(ll);
        System.out.println(cl.getRes());
    }
}
