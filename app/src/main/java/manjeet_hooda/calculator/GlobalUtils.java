package manjeet_hooda.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.Stack;

/**
 * Created by manjeet on 27/4/16.
 */
public class GlobalUtils {

    public static void evaluate(String expression) {
            char[] tokens = expression.toCharArray();

            // Stack for numbers: 'values'
            Stack<BigDecimal> values = new Stack<BigDecimal>();

            // Stack for Operators: 'ops'
            Stack<Character> ops = new Stack<Character>();

            for (int i = 0; i < tokens.length; i++) {
                // Current token is a whitespace, skip it
                if (tokens[i] == ' ')
                    continue;

                // Current token is a number, push it to stack for numbers
                if (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.') {
                    StringBuffer sbuf = new StringBuffer();
                    // There may be more than one digits in number
                    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9'|| i <tokens.length && tokens[i]=='.')
                        sbuf.append(tokens[i++]);
                    try {
                        Locale in_ID = new Locale("en","US");
                        DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(in_ID);
                        nf.setParseBigDecimal(true);
                        BigDecimal bd = (BigDecimal)nf.parse(sbuf.toString(), new ParsePosition(0));

                        values.push(bd);
                    }catch (NumberFormatException e){

                    }
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
            //return values.pop();
            MathContext mc = new MathContext(12);
            if(values != null) {
                BigDecimal bg = new BigDecimal(values.pop().toString(), mc);
                GlobalDataContainer.result_string = bg.toString();
            }
        }

        // Returns true if 'op2' has higher or same precedence as 'op1',
        // otherwise returns false.
        public static boolean hasPrecedence(char op1, char op2) {
            if (op1 == '(' || op2 == '(')
                return false;
            if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }

        // A utility method to apply an operator 'op' on operands 'a'
        // and 'b'. Return the result.
        public static BigDecimal applyOp(char op, BigDecimal b, BigDecimal a) {
            switch (op) {
                case '+':
                    return a.add(b);
                case '-':
                    return a.subtract(b);
                case '*':
                    return a.multiply(b);
                case '/':
                    if (b.compareTo(BigDecimal.ZERO) == 0)
                        throw new
                                UnsupportedOperationException("Cannot divide by zero");
                    return a.divide(b);
            }
            return BigDecimal.ZERO;
        }
}