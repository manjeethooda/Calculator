package manjeet_hooda.calculator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View.OnClickListener;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private MyPagerAdapter mPagerAdapter;


    TextView zero, one, two, three, four, five, six, seven, eight, nine, dot;
    TextView del, min, plus, div, mul, equals;
    TextView result;

    double answer, num1, num2;
    boolean operator_pressed,dot_pressed;
    boolean equals_pressed, answer_found;
    char operation;
    String result_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPager();





        result = (TextView)findViewById(R.id.result);
        answer = num1 = num2 = 0;
        operator_pressed = equals_pressed = false;
        dot_pressed = false;
        answer_found = false;
        result_string = null;

    }

    private void setupPager() {
        mViewPager = (ViewPager) findViewById(R.id.ViewPager);
        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),2);
        mViewPager.setAdapter(mPagerAdapter);
    }

}
