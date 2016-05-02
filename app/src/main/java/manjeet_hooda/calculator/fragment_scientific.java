package manjeet_hooda.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by manjeet on 24/4/16.
 */
public class fragment_scientific extends Fragment {

    private View view;
    private Button but_sin, but_cos, but_tan, but_sin_inv, but_cos_inv, but_tan_inv;
    private Button but_log, but_ln, but_e, but_op_brac, but_cl_brac, but_sqrt;
    private int op_brac_pos;
    private buttonListener callbackListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_scientific,container, false);
        setupFourthRowButton();
        setupFirstRowButton();
        setupSecondRowButton();
        setupThirdRowButton();
        return view;
    }

    private void setupFirstRowButton(){
        but_sin = (Button)view.findViewById(R.id.button_sin);
        but_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "s( ";
                callbackListener.onNumPressed();
            }
        });

        but_cos = (Button)view.findViewById(R.id.button_cos);
        but_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "c( ";
                callbackListener.onNumPressed();
            }
        });

        but_tan = (Button)view.findViewById(R.id.button_tan);
        but_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "t( ";
                callbackListener.onNumPressed();
            }
        });
    }

    private void setupSecondRowButton(){
        but_sin_inv = (Button)view.findViewById(R.id.button_sin_inv);
        but_sin_inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "p( ";
                callbackListener.onNumPressed();
            }
        });

        but_cos_inv = (Button)view.findViewById(R.id.button_cos_inv);
        but_cos_inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "q( ";
                callbackListener.onNumPressed();
            }
        });

        but_tan_inv = (Button)view.findViewById(R.id.button_tan_inv);
        but_tan_inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "r( ";
                callbackListener.onNumPressed();
            }
        });
    }

    private void setupThirdRowButton(){
        but_ln = (Button)view.findViewById(R.id.button_ln);
        but_ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "l( ";
                callbackListener.onNumPressed();
            }
        });

        but_log = (Button)view.findViewById(R.id.button_log);
        but_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "m( ";
                callbackListener.onNumPressed();
            }
        });

        but_e = (Button)view.findViewById(R.id.button_e);
        but_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "n( ";
                callbackListener.onNumPressed();
            }
        });
    }

    private void setupFourthRowButton(){
        but_op_brac = (Button)view.findViewById(R.id.button_op_bracket);
        but_op_brac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand  = false;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 1);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                GlobalDataContainer.op_brac_open_count++;
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " ( ";
                callbackListener.onOperandPressed();
            }
        });

        but_cl_brac = (Button)view.findViewById(R.id.button_cl_bracket);
        but_cl_brac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GlobalDataContainer.op_brac_pressed)
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " ) ";
                if(GlobalDataContainer.op_brac_open_count == 0)
                    GlobalDataContainer.op_brac_pressed = false;
                else
                    GlobalDataContainer.op_brac_open_count--;
                callbackListener.onOperandPressed();
            }
        });

        but_sqrt = (Button)view.findViewById(R.id.button_sqrt);
        but_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean last_char_operand = false;
                if (GlobalDataContainer.exp_string.length() > 0) {
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-' ||
                            last_char == 's' || last_char  == 't' || last_char == 'c' ||last_char == '(' ||
                            last_char == 'p' || last_char == 'q' || last_char == 'r' || last_char == 'o'||
                            last_char == 'l' || last_char == 'm' || last_char == 'n')
                        last_char_operand = true;
                }
                if(!last_char_operand && GlobalDataContainer.getExpLength() != 0) {
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                }
                GlobalDataContainer.op_brac_open_count++;
                GlobalDataContainer.op_brac_pressed = true;
                GlobalDataContainer.op_brac_opening = true;
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "o( ";
                callbackListener.onNumPressed();
            }
        });


    }

    public void setupListener(buttonListener listener){
        this.callbackListener = listener;
    }

}
