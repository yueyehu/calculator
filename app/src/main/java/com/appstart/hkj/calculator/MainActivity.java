package com.appstart.hkj.calculator;

//import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button bt_0;
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button bt_4;
    private Button bt_5;
    private Button bt_6;
    private Button bt_7;
    private Button bt_8;
    private Button bt_9;
    private Button bt_divide;
    private Button bt_mul;
    private Button bt_add;
    private Button bt_minus;
    private Button bt_equal;
    private Button bt_dot;
    private Button bt_clear;
    private Button bt_del;

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView1);

        bt_0 = (Button) findViewById(R.id.bt_zero);
        bt_0.setOnClickListener(this);

        bt_1 = (Button) findViewById(R.id.bt_one);
        bt_1.setOnClickListener(this);

        bt_2 = (Button) findViewById(R.id.bt_two);
        bt_2.setOnClickListener(this);

        bt_3 = (Button) findViewById(R.id.bt_three);
        bt_3.setOnClickListener(this);

        bt_4 = (Button) findViewById(R.id.bt_four);
        bt_4.setOnClickListener(this);

        bt_5 = (Button) findViewById(R.id.bt_five);
        bt_5.setOnClickListener(this);

        bt_6 = (Button) findViewById(R.id.bt_six);
        bt_6.setOnClickListener(this);

        bt_7 = (Button) findViewById(R.id.bt_seven);
        bt_7.setOnClickListener(this);

        bt_8 = (Button) findViewById(R.id.bt_eight);
        bt_8.setOnClickListener(this);

        bt_9 = (Button) findViewById(R.id.bt_nine);
        bt_9.setOnClickListener(this);

        bt_del = (Button) findViewById(R.id.bt_del);
        bt_del.setOnClickListener(this);

        bt_clear = (Button) findViewById(R.id.bt_clear);
        bt_clear.setOnClickListener(this);

        bt_dot = (Button) findViewById(R.id.bt_dot);
        bt_dot.setOnClickListener(this);

        bt_mul = (Button) findViewById(R.id.bt_mul);
        bt_mul.setOnClickListener(this);

        bt_divide = (Button) findViewById(R.id.bt_divide);
        bt_divide.setOnClickListener(this);

        bt_add = (Button) findViewById(R.id.bt_add);
        bt_add.setOnClickListener(this);

        bt_minus = (Button) findViewById(R.id.bt_minus);
        bt_minus.setOnClickListener(this);

        bt_equal = (Button) findViewById(R.id.bt_equal);
        bt_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch(arg0.getId()){
            case R.id.bt_zero:
            case R.id.bt_one:
            case R.id.bt_two:
            case R.id.bt_three:
            case R.id.bt_four:
            case R.id.bt_five:
            case R.id.bt_six:
            case R.id.bt_seven:
            case R.id.bt_eight:
            case R.id.bt_nine:
                tv.setText(tv.getText()+ ((Button)arg0).getText().toString());
                break;
            case R.id.bt_add:
            case R.id.bt_minus:
            case R.id.bt_divide:
            case R.id.bt_mul:
                if(tv.getText().length() > 0){
                    char ch = tv.getText().charAt(tv.getText().length()-1);
                    if(ch != '*' && ch != '+' && ch != '-' && ch != '/'){
                        tv.setText(tv.getText()+ ((Button)arg0).getText().toString());
                    }
                }
                break;
            case R.id.bt_dot:
                String str = tv.getText() + ".";
                Pattern pat = Pattern.compile("\\.[0-9]*\\.");
                Matcher op1 = pat.matcher(str);
                if(!op1.find())
                    tv.setText(tv.getText()+ ((Button)arg0).getText().toString());
                break;
            case R.id.bt_del:
                if(tv.getText().length()>0)
                    tv.setText(tv.getText().subSequence(0, tv.getText().length()-1));
                break;
            case R.id.bt_clear:
                tv.setText("");
                break;
            case R.id.bt_equal:
                String exp = tv.getText().toString();
                if(!exp.isEmpty()){
                    ExpCal ep = new ExpCal(exp);
                    tv.setText(ep.ExpResult().toString());
                }
                break;
        }

    }
}
