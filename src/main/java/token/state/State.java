package token.state;

public abstract class State {
    Tokenizer t;

    State(Tokenizer t) {
        this.t = t;
    }

    public abstract void process(char c);

    public abstract void addCurrToken();
}
