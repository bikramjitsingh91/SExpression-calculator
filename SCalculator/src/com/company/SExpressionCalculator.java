package com.company;

import java.util.Arrays;
import java.util.Stack;

public class SExpressionCalculator {

    public static void main(String[] args) {
        try {
           int eval = expressionCalc(args[0]);
           System.out.println("=> " + eval);
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }

    public static int expressionCalc(String expression) throws Exception{
        String[] expressions = expression.split(" ");
        //Using stack to store the numbers
        Stack<Integer> stack = new Stack<Integer>();
        int index = expressions.length - 1;
        while(index >= 0){
            if(expressions[index].contains("add") || expressions[index].contains("multiply")){
                int firstExpr   = stack.pop();
                int secondExpr  = stack.pop();

                if(expressions[index].contains("add"))
                    stack.push(firstExpr + secondExpr);
                else if(expressions[index].contains("multiply"))
                    stack.push(firstExpr * secondExpr );
            }
            else {
                String exprExtraction = expressions[index].replaceAll("[)]","");
                int expr = Integer.parseInt(exprExtraction);
                stack.push(expr);
            }
            index--;
        }
        return stack.pop();
    }
}
