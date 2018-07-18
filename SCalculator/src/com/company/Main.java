package com.company;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        try {
           int eval = expressionCalc(args[0]);
           System.out.println("=> " + eval);
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }

    private static int expressionCalc(String expression) throws Exception{
        String[] in = expression.split(" ");
        //Using stack to store the numbers
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = in.length-1 ; i >= 0 ; i--) {
            // Insert the expression after removing the closing bracket and double quotes.
            if(!in[i].contains("add") && !in[i].contains("multiply")){
                String exprExtraction = in[i].replaceAll("[)]","");
                int expr = Integer.parseInt(exprExtraction);
                stack.push(expr);
            }
            else {
                //Get expression stored at the top of the stack for evaluation
                int firstExpr   = stack.pop();
                int secondExpr  = stack.pop();

                if(in[i].contains("add"))
                    stack.push(firstExpr + secondExpr);
                else if(in[i].contains("multiply"))
                    stack.push(firstExpr * secondExpr );
            }
        }
        return stack.pop();
    }
}
