package token.operation;

public class DivOperation extends Operation {
    public String visualize() {
        return "DIV_OPERATION";
    }

    @Override
    public int operate(int fst, int snd) {
        return snd / fst;
    }
}
