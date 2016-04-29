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

import javax.microedition.khronos.opengles.GL;

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
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "8";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
                callbackListener.onNumPressed();
            }
        });

        but_five = (Button)view.findViewById(R.id.button_five);
        but_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "5";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
                callbackListener.onNumPressed();
            }
        });

        but_two = (Button)view.findViewById(R.id.button_two);
        but_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "2";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
                callbackListener.onNumPressed();
            }
        });

        but_zero = (Button)view.findViewById(R.id.button_zero);
        but_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "0";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
                callbackListener.onNumPressed();
            }
        });
    }

    public void setupThirdColumnButtons(){
        but_nine = (Button)view.findViewById(R.id.button_nine);
        but_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "9";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
                callbackListener.onNumPressed();
            }
        });

        but_six = (Button)view.findViewById(R.id.button_six);
        but_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "6";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
                callbackListener.onNumPressed();
            }
        });

        but_three = (Button)view.findViewById(R.id.button_three);
        but_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "3";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
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
                callbackListener.onNumPressed();
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
                    if(GlobalDataContainer.exp_string!= null && GlobalDataContainer.exp_string.length() >0 )
                    {
                        GlobalDataContainer.exp_string =
                                        GlobalDataContainer.exp_string.substring(0, GlobalDataContainer.exp_string.length() - 1);
                        if(GlobalDataContainer.exp_string != null && GlobalDataContainer.exp_string.length()>0) {
                            char lastChar = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length()-1);
                            if(lastChar >= '0' && lastChar <= '9' ) {
                                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
                                if(GlobalDataContainer.exp_string.indexOf('.') < 0)
                                    GlobalDataContainer.dot_pressed = false;
                            }
                        }
                        else{
                            GlobalDataContainer.reset_variables();
                        }
                        callbackListener.onNumPressed();
                    }
                }
            }
        });

        but_plus = (Button)view.findViewById(R.id.button_plus);
        but_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " + ";
                callbackListener.onOperandPressed();
            }
        });

        but_minus = (Button)view.findViewById(R.id.button_min);
        but_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " - ";
                callbackListener.onOperandPressed();
            }
        });

        but_mul = (Button)view.findViewById(R.id.button_mul);
        but_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
                callbackListener.onOperandPressed();
            }
        });

        but_div = (Button)view.findViewById(R.id.button_div);
        but_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " / ";
                callbackListener.onOperandPressed();
            }
        });

    }

}
