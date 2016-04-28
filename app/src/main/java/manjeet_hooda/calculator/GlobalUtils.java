package manjeet_hooda.calculator;

import java.util.Stack;

/**
 * Created by manjeet on 27/4/16.
 */
public class GlobalUtils {

    public static void num_pressed(String num) {
        GlobalDataContainer.last_char_operand = false;
        GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + num;
        if (!GlobalDataContainer.operand_pressed) {
            GlobalDataContainer.num1_string = GlobalDataContainer.num1_string + num;
        } else {/*{
            if (!GlobalDataContainer.operand_repressed) {
                GlobalDataContainer.num2_string = GlobalDataContainer.num2_string + num;
            } else {
                GlobalDataContainer.num1_string = GlobalDataContainer.result_string;
                GlobalDataContainer.num2_string = "";
                GlobalDataContainer.num2_string = GlobalDataContainer.num2_string + num;
                GlobalDataContainer.operand_repressed = false;
            }*/
            int a =evaluate(GlobalDataContainer.exp_string);
            if (GlobalDataContainer.dot_pressed)
                GlobalDataContainer.result_string = String.valueOf(GlobalDataContainer.result_double);
            else {
                //GlobalDataContainer.result_string = String.valueOf(GlobalDataContainer.result_double.intValue());
                GlobalDataContainer.result_string = String.valueOf(a);
            }
        }

    }

    public static void find_answer() {
        if (GlobalDataContainer.num1_string.equals("") | GlobalDataContainer.num1_string.equals(".") |
                GlobalDataContainer.num2_string.equals("") | GlobalDataContainer.num2_string.equals("."))
            return;

        try {
            GlobalDataContainer.num1_double = Double.parseDouble(GlobalDataContainer.num1_string);
            GlobalDataContainer.num2_double = Double.parseDouble(GlobalDataContainer.num2_string);
        } catch (Exception e) {

        }
        switch (GlobalDataContainer.operand) {
            case '+':
                GlobalDataContainer.result_double = GlobalDataContainer.num1_double +
                        GlobalDataContainer.num2_double;
                break;
            case '-':
                GlobalDataContainer.result_double = GlobalDataContainer.num1_double -
                        GlobalDataContainer.num2_double;
                break;
            case '/':
                GlobalDataContainer.result_double = GlobalDataContainer.num1_double /
                        GlobalDataContainer.num2_double;
                break;
            case 'x':
                GlobalDataContainer.result_double = GlobalDataContainer.num1_double *
                        GlobalDataContainer.num2_double;
                break;
            default:
                GlobalDataContainer.result_double = 0.0;
        }
        if (GlobalDataContainer.dot_pressed)
            GlobalDataContainer.result_string = String.valueOf(GlobalDataContainer.result_double);
        else {
            GlobalDataContainer.result_string = String.valueOf(GlobalDataContainer.result_double.intValue());
        }
        return;
    }

        public static int evaluate(String expression) {
            char[] tokens = expression.toCharArray();

            // Stack for numbers: 'values'
            Stack<Integer> values = new Stack<Integer>();

            // Stack for Operators: 'ops'
            Stack<Character> ops = new Stack<Character>();

            for (int i = 0; i < tokens.length; i++) {
                // Current token is a whitespace, skip it
                if (tokens[i] == ' ')
                    continue;

                // Current token is a number, push it to stack for numbers
                if (tokens[i] >= '0' && tokens[i] <= '9') {
                    StringBuffer sbuf = new StringBuffer();
                    // There may be more than one digits in number
                    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                        sbuf.append(tokens[i++]);
                    values.push(Integer.parseInt(sbuf.toString()));
                }

                // Current token is an opening brace, push it to 'ops'
                else if (tokens[i] == '(')
                    ops.push(tokens[i]);

                    // Closing brace encountered, solve entire brace
                else if (tokens[i] == ')') {
                    while (ops.peek() != '(')
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.pop();
                }

                // Current token is an operator.
                else if (tokens[i] == '+' || tokens[i] == '-' ||
                        tokens[i] == '*' || tokens[i] == '/') {
                    // While top of 'ops' has same or greater precedence to current
                    // token, which is an operator. Apply operator on top of 'ops'
                    // to top two elements in values stack
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                    // Push current token to 'ops'.
                    ops.push(tokens[i]);
                }
            }

            // Entire expression has been parsed at this point, apply remaining
            // ops to remaining values
            while (!ops.empty())
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));

            // Top of 'values' contains result, return it
            return values.pop();
        }

        // Returns true if 'op2' has higher or same precedence as 'op1',
        // otherwise returns false.
        public static boolean hasPrecedence(char op1, char op2) {
            if (op2 == '(' || op2 == ')')
                return false;
            if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }

        // A utility method to apply an operator 'op' on operands 'a'
        // and 'b'. Return the result.
        public static int applyOp(char op, int b, int a) {
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    if (b == 0)
                        throw new
                                UnsupportedOperationException("Cannot divide by zero");
                    return a / b;
            }
            return 0;
        }
}