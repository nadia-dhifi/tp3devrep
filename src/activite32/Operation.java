package activite32;
import java.io.Serializable;


public class Operation implements Serializable {
    private double operand1;
    private String operator;
    private double operand2;

    public Operation(double operand1, int i, double operand2) {
        this.operand1 = operand1;
        this.operator = i;
        this.operand2 = operand2;
    }

    public double getOperand11() {
        return operand1;
    }

    public String getOperator1() {
        return operator;
    }

    public double getOperand21() {
        return operand2;
    }
    // Méthodes getters pour accéder aux membres de la classe

    public double getOperand1() {
        return operand1;
    }

    public String getOperator() {
        return operator;
    }

    public double getOperand2() {
        return operand2;
    }

    // Méthodes setters pour modifier les membres de la classe

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }


    // Méthode pour effectuer le calcul
    public double calculate() {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                   return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Unsupported operator");
        }
    }

    @Override
    public String toString() {
        return operand1 + " " + operator + " " + operand2;
    }
}