package token;

import visitor.TokenVisitor;

public class NumberToken implements Token {
    private int num;

    public NumberToken(int n) {
        num = n;
    }

    public void accept(TokenVisitor visitor) {

    }

    public String visualize() {
        return "NUMBER(" + num + ")";
    }
}
