package manjeet_hooda.calculator;

import android.os.Bundle;
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

        setup_zero();
        setup_one();
        setup_two();
        setup_three();
        setup_four();
        setup_five();
        setup_six();
        setup_seven();
        setup_eight();
        setup_nine();
        setup_dot();

        setup_delete();
        setup_minus();
        setup_mul();
        setup_div();
        setup_add();
        setup_equals();

        result = (TextView)findViewById(R.id.result);
        answer = num1 = num2 = 0;
        operator_pressed = equals_pressed = false;
        dot_pressed = false;
        answer_found = false;
        result_string = null;

    }

    public void get_number(){
        if(operator_pressed && result_string != null) {
            num1 = Double.parseDouble(result_string);

        }
        if(equals_pressed && result_string != null)
        {
            num2 = Double.parseDouble(result_string);

        }
    }

    public void setup_add(){
        plus = (TextView)findViewById(R.id.f_add);
        plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        operation = '+';
                        operator_pressed = true;
                        get_number();
                        result_string = null;
                        operator_pressed = false;
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setup_minus(){
        min = (TextView)findViewById(R.id.f_minus);
        min.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        operation = '-';
                        operator_pressed = true;
                        get_number();
                        result_string = null;
                        operator_pressed = false;
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void setup_mul(){
        mul = (TextView)findViewById(R.id.f_mul);
        mul.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        operation = 'x';
                        operator_pressed = true;
                        get_number();
                        result_string = null;
                        operator_pressed = false;
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void setup_div(){
        div = (TextView) findViewById(R.id.f_div);
        div.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        operation = '/';
                        operator_pressed = true;
                        get_number();
                        result_string = null;
                        operator_pressed = false;
                        dot_pressed = true;
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setup_equals(){
        equals = (TextView) findViewById(R.id.f_equals);
        equals.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        equals_pressed = true;
                        get_number();
                        result_string = null;
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                get_result();

            }
        });
    }

    public void get_result(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                switch (operation){
                    case '+': answer = num1 + num2;
                        break;
                    case '-': answer = num1 - num2;
                        break;
                    case 'x': answer = num1 * num2;
                        break;
                    case '/': answer = (num2 != 0)?num1 / num2: 0;
                        break;
                    default: answer = 0;
                }
                if(dot_pressed)
                    result_string = Double.toString(answer);
                else
                    result_string = Integer.toString((int)answer);
                num1 = num2 = answer = 0;
                equals_pressed  = false;
                answer_found = true;
            }
        };
        Thread t = new Thread(r);
        t.start();
        try {
            t.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        display();

    }

    public void display(){
        //if(!operator_pressed && !dot_pressed)
        result.setText(result_string);
    }

    public void delete () {
        if (result_string != null && result_string.length() > 0)
        {

            result_string = result_string.substring(0, result_string.length()-1);
        }
        if(result_string == null)
            result_string = null;
    }

    public void setup_delete(){
            del = (TextView)findViewById(R.id.f_del);
            del.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            delete();
                        }
                    };
                    Thread t = new Thread(r);
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    display();
                }
            });
    }

    public void setup_zero(){
        zero = (TextView)findViewById(R.id.d_zero);
        zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if(answer_found) {
                            result_string = null;
                            answer_found = false;
                            dot_pressed = false;
                        }
                        if (result_string != null)
                            result_string = result_string.concat("0");
                        else
                            result_string = null;
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_one(){
        one = (TextView)findViewById(R.id.d_one);
        one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat("1");
                        else
                            result_string = "1";
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_two(){
        two = (TextView)findViewById(R.id.d_two);
        two.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat("2");
                        else
                            result_string = "2";
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_three(){
        three = (TextView)findViewById(R.id.d_three);
        three.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat("3");
                        else
                            result_string = "3";
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_four(){
        four = (TextView)findViewById(R.id.d_four);
        four.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat("4");
                        else
                            result_string = "4";
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_five(){
        five = (TextView)findViewById(R.id.d_five);
        five.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat("5");
                        else
                            result_string = "5";
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_six(){
        six = (TextView)findViewById(R.id.d_six);
        six.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat("6");
                        else
                            result_string = "6";
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_seven(){
        seven = (TextView)findViewById(R.id.d_seven);
        seven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat("7");
                        else
                            result_string = "7";
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_eight(){
        eight = (TextView)findViewById(R.id.d_eight);
        eight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat("8");
                        else
                            result_string = "8";
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_nine(){
        nine = (TextView)findViewById(R.id.d_nine);
        nine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat("9");
                        else
                            result_string = "9";
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }

    public void setup_dot(){
        dot = (TextView)findViewById(R.id.d_point);
        dot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        if (result_string != null)
                            result_string = result_string.concat(".");
                        else
                            result_string = ".";

                        dot_pressed = true;
                    }
                };
                Thread t = new Thread(r);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                display();
            }
        });
    }


}
