package token.operation;

import token.Token;
import visitor.TokenVisitor;

public abstract class Operation implements Token {
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
    public abstract int operate(int fst, int snd);
}
