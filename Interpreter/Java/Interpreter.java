class Interpreter {

    static abstract class Expression {
        abstract int interpret(int num);
    }

    static class TerminalExpression extends Expression {

        int interpret(int num) {
            return num;
        }

    }

    static class ConstantExpression extends Expression {

        private int constant;

        ConstantExpression(int constant) {
            this.constant = constant;
        }

        int interpret(int num) {
            return constant;
        }

    }

    static class AddExpression extends Expression {

        private Expression exp1;
        private Expression exp2;

        AddExpression(Expression exp1, Expression exp2) {
            this.exp1 = exp1;
            this.exp2 = exp2;
        }

        int interpret(int num) {
            return exp1.interpret(num) + exp2.interpret(num);
        }
    }

    static class MultiplyExpression extends Expression {

        private Expression exp1;
        private Expression exp2;

        MultiplyExpression(Expression exp1, Expression exp2) {
            this.exp1 = exp1;
            this.exp2 = exp2;
        }

        int interpret(int num) {
            return exp1.interpret(num) * exp2.interpret(num);
        }
    }

    /*
        2 * x * x + 4 * x + 1
    */
    static Expression buildExpressionTree() {
        Expression exp1 =   new MultiplyExpression(
                                new MultiplyExpression(
                                    new TerminalExpression(),
                                    new TerminalExpression()
                                ),
                                new ConstantExpression(2)
                            );
        Expression exp2 =   new MultiplyExpression(
                                new TerminalExpression(),
                                new ConstantExpression(4)
                            );
        Expression exp3 = new ConstantExpression(1);

        return new AddExpression(new AddExpression(exp1, exp2), exp3);
    }

    public static void main(String[] args) {
        Expression exp = buildExpressionTree();

        System.out.println(exp.interpret(2));
    }

}
