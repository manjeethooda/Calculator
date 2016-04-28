package manjeet_hooda.calculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ButtonBarLayout;
import android.telephony.gsm.GsmCellLocation;
import android.view.View.OnClickListener;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import me.grantland.widget.AutofitTextView;

public class MainActivity extends AppCompatActivity implements buttonListener {

    private ViewPager mViewPager;
    private MyPagerAdapter mPagerAdapter;

    private AutofitTextView result, exp;
    private Button but_sev, but_four, but_one, but_dot;
    private Context context;


    double answer, num1, num2;
    boolean operator_pressed,dot_pressed;
    boolean equals_pressed, answer_found;
    char operation;
    String result_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (AutofitTextView) findViewById(R.id.result);
        exp = (AutofitTextView) findViewById(R.id.exp);
        GlobalDataContainer.reset_variables();
        context = this;

        setupPager();
        setupButtons();
    }

    public void updateExpTextView(){
        exp.setText(GlobalDataContainer.exp_string);
    }

    public void updateResultTextView(){
        result.setText(GlobalDataContainer.result_string);
    }

    private void setupPager() {
        mViewPager = (ViewPager) findViewById(R.id.ViewPager);
        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),2,this);
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onNumPressed() {
        updateExpTextView();
        updateResultTextView();
    }

    @Override
    public void onOperandPressed() {
        updateExpTextView();
    }

    @Override
    public void onEqualsPressed() {
        updateExpTextView();
    }

    public void setupButtons(){
        but_sev = (Button)findViewById(R.id.button_seven);
        but_sev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "7";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
                updateExpTextView();
                updateResultTextView();
            }
        });

        but_four = (Button)findViewById(R.id.button_four);
        but_four.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "4";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);updateExpTextView();
                updateResultTextView();
            }
        });

        but_one = (Button)findViewById(R.id.button_one);
        but_one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.exp_string = GlobalDataContainer.exp_string + "1";
                GlobalUtils.evaluate(GlobalDataContainer.exp_string);
                updateExpTextView();
                updateResultTextView();
            }
        });

        but_dot = (Button)findViewById(R.id.button_dot);
        but_dot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalDataContainer.dot_pressed = true;
                updateExpTextView();
                updateResultTextView();
            }
        });

    }


}
