package com.example.enclaveit.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvSentenceOne;
    private RadioGroup rdSentenceOne;

    private RadioButton radA;
    private RadioButton radB;

    private Button result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!findWidgetAndroid()){
            return;
        }

        if(!setTitleForQuestion("Format name skype is \"VUONG(LORENCE) V. NGUYEN\" is right or wrong?")){
            return;
        }
        if(!setValueItemRadioButton("You are right","You are wrong")){
            return;
        };

        if(!onClickButtonResult("When you click to get data from radio button,So you need to check click to see result")){
            return;
        };

        int id  = rdSentenceOne.getCheckedRadioButtonId();

        function2();
    }

    private boolean onClickButtonResult(String s) {
        Toast.makeText(MainActivity.this,String.valueOf(s),Toast.LENGTH_LONG).show();
        boolean valid = false;
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rdSentenceOne.getCheckedRadioButtonId();
                RadioButton radio = (RadioButton) findViewById(id);
                Log.d("RESULT","You choosed: "+String.valueOf(radio.getText()));
            }
        });
        return valid;
    }

    private boolean setTitleForQuestion(String s) {
        boolean valid = true;
        try{
            if(s.isEmpty()){
                throw new IsEmperorException("Value to set textview is empty!");
            }{
                /** This is fragmnet code that you move it to here */
                tvSentenceOne.setText("Format name skype is \"VUONG(LORENCE) V. NGUYEN\" is right or wrong?");
            }
        }catch (IsEmperorException ex){
            Log.d("ERROR",ex.getMessage());
        }
        return valid;
    }

    private boolean setValueItemRadioButton(String s, String s1) {
        boolean valid = true;
        try{
            if(s.isEmpty() || s1.isEmpty()){
                throw new IsEmperorException("Value to set radio button is empty!");
            }else{
                radA.setText(s);
                radB.setText(s1);
            }
        }catch (IsEmperorException ex){
            Log.d("ERROR",ex.getMessage());
            valid = false;
        }
        return valid;
    }

    private void function2() {
    }

    private boolean findWidgetAndroid() {
        tvSentenceOne = (TextView)this.findViewById(R.id.tvSentenceOne);
        rdSentenceOne = (RadioGroup)this.findViewById(R.id.rdSentenceOne);

        radA = (RadioButton)this.findViewById(R.id.s1a);
        radB = (RadioButton)this.findViewById(R.id.s1b);

        result = (Button)this.findViewById(R.id.result);
        return true;
    }
}
