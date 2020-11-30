package visitor;

import token.NumberToken;
import token.Token;
import token.brace.Brace;
import token.brace.LeftBracket;
import token.operation.DivOperation;
import token.operation.MultOperation;
import token.operation.Operation;

import java.util.ArrayList;
import java.util.List;

public class ParserVisitor implements TokenVisitor {

    private List<Token> tokens = new ArrayList<Token>();
    private List<Token> ops = new ArrayList<Token>();


    public List<Token> visit(List<Token> tokens) {
        tokens.clear();
        ops.clear();
        for (Token t: tokens) {
            if (t instanceof Brace ||
            t instanceof Operation ||
            t instanceof NumberToken) {
                visit(t);
            }
        }
        return tokens;
    }

    public void visit(NumberToken token) {
        tokens.add(token);
    }

    public void visit(Brace token) {
        if (token instanceof LeftBracket) {
            ops.add(token);
        } else {
            if (ops.isEmpty()) {
                throw new RuntimeException("Parse error. Check parenthesis");
            }
            while (!(ops.get(ops.size() - 1) instanceof LeftBracket)) {
                tokens.add(ops.get(ops.size() - 1));
                ops.remove(ops.size() - 1);
            }
            ops.remove(ops.size() - 1);
        }
    }

    public void visit(Operation token) {
        if (token instanceof MultOperation || token instanceof DivOperation) {
            if (!ops.isEmpty()) {
                Token token1 = ops.get(ops.size() - 1);
                if (token1 instanceof MultOperation ||
                        token1 instanceof DivOperation) {
                    tokens.add(token1);
                    ops.remove(ops.size() - 1);
                }
                ops.add(token);
            }
        } else {
            if (!ops.isEmpty()) {
                Token token1 = ops.get(ops.size() - 1);
                if (!(token1 instanceof Brace)) {
                    tokens.add(token1);
                    ops.remove(ops.size() - 1);
                }
                ops.add(token);
            }
        }
    }
}
