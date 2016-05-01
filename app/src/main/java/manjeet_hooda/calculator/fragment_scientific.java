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
        return view;
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
                    char last_char = GlobalDataContainer.exp_string.charAt(GlobalDataContainer.exp_string.length() - 2);
                    if(last_char == '+' || last_char == '*' || last_char == '/' || last_char == '-')
                        last_char_operand = true;
                }
                if(!last_char_operand)
                    GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + " * ";
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
                GlobalDataContainer.op_brac_pressed = false;
                callbackListener.onOperandPressed();
            }
        });

    }

    public void setupListener(buttonListener listener){
        this.callbackListener = listener;
    }

}
