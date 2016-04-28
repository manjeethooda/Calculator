package manjeet_hooda.calculator;

/**
 * Created by manjeet on 24/4/16.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment_simple extends Fragment {

    private View view;

    private Button but_eight, but_five, but_two, but_zero;
    private Button but_nine, but_six, but_three, but_equals;
    private Button but_del, but_div, but_mul, but_minus, but_plus;
    private buttonListener callbackListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_simple,container, false);
        setupSecondColumnButtons();
        setupThirdColumnButtons();
        setupFourthColumnButtons();
        return view;
    }

    public void setupListener(buttonListener listener){
        this.callbackListener = listener;
    }

    public void setupSecondColumnButtons(){
        but_eight = (Button)view.findViewById(R.id.button_eight);
        but_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalUtils.num_pressed("8");
                callbackListener.onNumPressed();
            }
        });

        but_five = (Button)view.findViewById(R.id.button_five);
        but_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalUtils.num_pressed("5");
                callbackListener.onNumPressed();
            }
        });

        but_two = (Button)view.findViewById(R.id.button_two);
        but_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalUtils.num_pressed("2");
                callbackListener.onNumPressed();
            }
        });

        but_zero = (Button)view.findViewById(R.id.button_zero);
        but_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalUtils.num_pressed("0");
                callbackListener.onNumPressed();
            }
        });
    }

    public void setupThirdColumnButtons(){
        but_nine = (Button)view.findViewById(R.id.button_nine);
        but_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalUtils.num_pressed("9");
                callbackListener.onNumPressed();
            }
        });

        but_six = (Button)view.findViewById(R.id.button_six);
        but_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalUtils.num_pressed("6");
                callbackListener.onNumPressed();
            }
        });

        but_three = (Button)view.findViewById(R.id.button_three);
        but_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalUtils.num_pressed("3");
                callbackListener.onNumPressed();
            }
        });

        but_equals = (Button)view.findViewById(R.id.button_equal);
        but_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String store_result = GlobalDataContainer.result_string;
                GlobalDataContainer.reset_variables();
                GlobalDataContainer.num1_string = store_result;
                GlobalDataContainer.exp_string = GlobalDataContainer.num1_string;
                GlobalDataContainer.delete_button_string = "CLR";
                but_del.setText(GlobalDataContainer.delete_button_string);
                callbackListener.onEqualsPressed();
            }
        });
    }

    private void setupFourthColumnButtons(){
        but_del = (Button)view.findViewById(R.id.button_del);
        but_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GlobalDataContainer.delete_button_string.equals("CLR")){
                    GlobalDataContainer.reset_variables();
                    GlobalDataContainer.delete_button_string = "DEL";
                    but_del.setText(GlobalDataContainer.delete_button_string);
                    callbackListener.onNumPressed();
                }
                else{
                    if(!GlobalDataContainer.operand_pressed){
                        if(GlobalDataContainer.num1_string.length()>0)
                        {
                            GlobalDataContainer.num1_string =
                                    GlobalDataContainer.num1_string.substring(0,GlobalDataContainer.num1_string.length()-1);
                            GlobalDataContainer.exp_string =
                                    GlobalDataContainer.exp_string.substring(0,GlobalDataContainer.exp_string.length()-1);
                            callbackListener.onEqualsPressed();
                        }

                    }
                    else{
                        if(GlobalDataContainer.last_char_operand){
                            if(GlobalDataContainer.exp_string.length()>0) {
                                GlobalDataContainer.exp_string =
                                        GlobalDataContainer.exp_string.substring(0, GlobalDataContainer.exp_string.length() - 1);
                                callbackListener.onEqualsPressed();
                            }
                        }
                        else
                        {
                            if(GlobalDataContainer.num2_string.length()>0)
                            {
                                GlobalDataContainer.num2_string =
                                        GlobalDataContainer.num2_string.substring(0, GlobalDataContainer.num2_string.length() - 1);
                                GlobalDataContainer.exp_string =
                                        GlobalDataContainer.exp_string.substring(0, GlobalDataContainer.exp_string.length() - 1);
                                GlobalUtils.find_answer();
                                callbackListener.onNumPressed();
                            }
                        }
                    }
                }
            }
        });

        but_plus = (Button)view.findViewById(R.id.button_plus);
        but_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!GlobalDataContainer.operand_pressed) {
                    GlobalDataContainer.operand_pressed = true;
                    GlobalDataContainer.operand = '+';
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "+";
                    callbackListener.onOperandPressed();
                }
                else{
                    GlobalDataContainer.operand_repressed = true;
                    if(!GlobalDataContainer.last_char_operand) {
                        GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "+";
                        GlobalDataContainer.operand = '+';
                        GlobalDataContainer.last_char_operand = true;
                        callbackListener.onOperandPressed();
                    }
                }
            }
        });

        but_minus = (Button)view.findViewById(R.id.button_min);
        but_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!GlobalDataContainer.operand_pressed) {
                    GlobalDataContainer.operand_pressed = true;
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "-";
                    GlobalDataContainer.operand = '-';
                    callbackListener.onOperandPressed();
                }
                else{
                    GlobalDataContainer.operand_repressed = true;
                    if(!GlobalDataContainer.last_char_operand) {
                        GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "-";
                        GlobalDataContainer.operand = '-';
                        GlobalDataContainer.last_char_operand = true;
                        callbackListener.onOperandPressed();
                    }
                }
            }
        });

        but_mul = (Button)view.findViewById(R.id.button_mul);
        but_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!GlobalDataContainer.operand_pressed) {
                    GlobalDataContainer.operand_pressed = true;
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "x";
                    GlobalDataContainer.operand = 'x';
                    callbackListener.onOperandPressed();
                }
                else{
                    GlobalDataContainer.operand_repressed = true;
                    if(!GlobalDataContainer.last_char_operand) {
                        GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "x";
                        GlobalDataContainer.operand = 'x';
                        GlobalDataContainer.last_char_operand = true;
                        callbackListener.onOperandPressed();
                    }
                }
            }
        });

        but_div = (Button)view.findViewById(R.id.button_div);
        but_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!GlobalDataContainer.operand_pressed) {
                    GlobalDataContainer.operand_pressed = true;
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "/";
                    GlobalDataContainer.operand = '/';
                    callbackListener.onOperandPressed();
                }
                else{
                    GlobalDataContainer.operand_repressed = true;
                    if(!GlobalDataContainer.last_char_operand) {
                        GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "/";
                        GlobalDataContainer.operand = '/';
                        GlobalDataContainer.last_char_operand = true;
                        callbackListener.onOperandPressed();
                    }
                }
            }
        });

    }

}
