package token;

import visitor.TokenVisitor;

public class NumberToken implements Token {
    private final int num;

    public NumberToken(int n) {
        num = n;
    }

    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    public String visualize() {
        return "NUMBER(" + num + ")";
    }

    public int getNum() {
        return num;
    }
}
