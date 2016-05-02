package manjeet_hooda.calculator;

/**
 * Created by manjeet on 25/4/16.
 */
public class GlobalDataContainer {

    public static boolean dot_pressed;
    public static boolean equals_pressed;
    public static boolean operand_pressed;
    public static boolean operand_repressed;
    public static char operand;
    public static boolean last_char_operand;
    public static String delete_button_string = "DEL";
    public static String exp2_string;
    public static boolean op_brac_pressed;
    public static boolean op_brac_opening;
    public static int op_brac_open_count;

    public static String result_string = "";
    public static String exp_string="";
    public static String num1_string="";
    public static String num2_string="";

    public static Double num1_double;
    public static Double num2_double;
    public static Double result_double;

    public static int num1_int;
    public static int num2_int;
    public static int num3_result;

    public static void reset_variables(){
        dot_pressed=false;
        equals_pressed = false;
        operand_pressed = false;
        operand_repressed = false;
        op_brac_pressed = false;
        op_brac_opening = false;

        result_string = "";
        exp_string="";
        exp2_string="";
        num1_string="";
        num2_string="";

        op_brac_open_count = 0;
        num1_double=0.0;
        num2_double=0.0;
        result_double=0.0;

        num1_int=0;
        num2_int=0;
        num3_result=0;
    }

    public static int getExpLength(){
        return exp_string.length();
    }

}
