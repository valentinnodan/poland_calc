package visitor;

import token.Token;
import token.brace.Brace;
import token.NumberToken;
import token.operation.Operation;

import java.util.List;

public interface TokenVisitor {
    void visit(NumberToken token);
    void visit(Brace token);
    void visit(Operation token);
}
