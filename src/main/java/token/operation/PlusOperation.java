package token.operation;

public class PlusOperation extends Operation {
    public String visualize() {
        return "PLUS_OPERATION";
    }

    @Override
    public int operate(int fst, int snd) {
        return fst + snd;
    }
}
