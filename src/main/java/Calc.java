import token.Token;
import token.state.Tokenizer;

import java.util.List;

public class Calc {
    public static void main(String[] args) {
        Tokenizer t = new Tokenizer();
        List<Token> l = t.tokenize("(30 + 2) / 8");
        for (Token token: l) {
            System.out.print(token.visualize());
            System.out.print(" ");
        }
    }
}
