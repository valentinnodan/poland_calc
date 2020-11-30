package token.state;

import token.Token;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private State currState = new UniversalState(this);
    private List<Token> tokenList = new ArrayList<Token>();

    public List<Token> tokenize(String s) {
        tokenList.clear();
        currState = new UniversalState(this);
        for (int i = 0; i < s.length(); i++) {
            currState.process(s.charAt(i));
        }
        endProcess();
        return tokenList;
    }

    void setState(State s) {
        currState = s;
    }

    void addToken(Token t) {
        tokenList.add(t);
    }
    void endProcess() {
        currState.addCurrToken();
        currState = new EndState(this);
    }
}
