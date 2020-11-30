package token.state;

import token.brace.LeftBracket;
import token.brace.RightBracket;
import token.operation.DivOperation;
import token.operation.MultOperation;
import token.operation.PlusOperation;
import token.operation.SubOperation;

public class UniversalState extends State{

    public UniversalState(Tokenizer t) {
        super(t);
    }

    UniversalState(Tokenizer t, char c) {
        super(t);
        addToken(c);
    }

    private void addToken(char c) {
        switch (c) {
            case '+':
                t.addToken(new PlusOperation());
                break;
            case '-':
                t.addToken(new SubOperation());
                break;
            case '*':
                t.addToken(new MultOperation());
                break;
            case '/':
                t.addToken(new DivOperation());
                break;
            case '(':
                t.addToken(new LeftBracket());
                break;
            case ')':
                t.addToken(new RightBracket());
                break;
        }
    }

    public void process(char c) {
        if (Character.isDigit(c)) {
            t.setState(new NumberState(t, c));
        } else {
            addToken(c);
        }
    }

    public void addCurrToken() {

    }

}
