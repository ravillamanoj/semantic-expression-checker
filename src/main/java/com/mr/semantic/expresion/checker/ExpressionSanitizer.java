package com.mr.semantic.expresion.checker;

/**
 * Sanitizes the input expression.
 *
 * @author Manoj
 */
public class ExpressionSanitizer {
    String inputExpression;

    ExpressionSanitizer(String inputString) {
        this.inputExpression = inputString;
    }

    public String replace() {
        String var_num = "";
        String var_replace = "";
        String newline = "";

        int m;

        for (int i = 0, j = 0; i < inputExpression.length(); i++) {
            if (inputExpression.charAt(i) == ',') {
                j = i + 1;
                while (inputExpression.charAt(j) != '=') {
                    j++;
                }
                m = j + 1;
                do {

                    m++;

                } while ((m < inputExpression.length()) && (inputExpression.charAt(m) != ','));
                try {
                    var_num = inputExpression.substring(j + 1, m);
                } catch (Exception e) {
                    System.out.println("invalid input");
                }

                try {
                    var_replace = inputExpression.substring(i + 1, j);
                } catch (Exception e) {
                    System.out.println("invalid input");
                }

                inputExpression = inputExpression.replaceAll(var_replace, var_num);

            }
        }
        for (int i = 0; i < inputExpression.length(); i++) {
            if (inputExpression.charAt(i) == ',') {
                newline = inputExpression.substring(0, i);
                break;
            }
        }
        return newline;
    }
}
