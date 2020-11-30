package token.operation;

public class SubOperation extends Operation {
    public String visualize() {
        return "SUB_OPERATION";
    }

    @Override
    public int operate(int fst, int snd) {
        return snd - fst;
    }
}
