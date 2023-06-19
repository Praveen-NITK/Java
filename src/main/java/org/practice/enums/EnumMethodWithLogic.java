package org.practice.enums;

public class EnumMethodWithLogic {
    enum Operation {
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPLY;

        double calculate(int x, int y){
            switch (this){
                case PLUS:
                    return x+y;
                case MINUS:
                    return x-y;
                case DIVIDE:
                    return x/y;
                case MULTIPLY:
                    return x*y;
                default:
                    throw new AssertionError("Un known operation "+this);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.calculate(2,3));
        System.out.println(Operation.MULTIPLY.calculate(2,3));
    }
}
