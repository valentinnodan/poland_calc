package token.operation;

public class MultOperation extends Operation {
    public String visualize() {
        return "MULT_OPERATION";
    }

    @Override
    public int operate(int fst, int snd) {
        return fst * snd;
    }
}
