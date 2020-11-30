package visitor;

import token.NumberToken;
import token.Token;
import token.brace.Brace;
import token.operation.Operation;

import java.util.ArrayList;
import java.util.List;

public class CalcVisitor implements TokenVisitor {

    ArrayList<Integer> stack = new ArrayList<>();

    public int visit(List<Token> tokens) {
        stack.clear();
        for (Token t : tokens) {
            t.accept(this);
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public void visit(NumberToken token) {
        stack.add(token.getNum());
    }

    @Override
    public void visit(Brace token) {
        throw new IllegalArgumentException("Expression in RPN should not have brackets");
    }

    @Override
    public void visit(Operation token) {
        assert(stack.size() >= 2);
        int fst = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        int snd = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        stack.add(token.operate(fst, snd));
    }
}
