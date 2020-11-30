package token.state;

import token.NumberToken;

public class NumberState extends State {
    StringBuilder numberRepresentation;
    public NumberState(Tokenizer t, char c) {
        super(t);
        numberRepresentation = new StringBuilder();
        numberRepresentation.append(c);
    }

    public void process(char c) {
        if (Character.isDigit(c)) {
            numberRepresentation.append(c);
        } else {
            addCurrToken();
            t.setState(new UniversalState(t, c));
        }
    }

    public void addCurrToken() {
        t.addToken(new NumberToken(Integer.parseInt(numberRepresentation.toString())));
    }

}
