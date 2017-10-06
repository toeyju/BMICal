package com.example.bmical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
TextView t;
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t = (TextView) findViewById(R.id.show);
        t1 =(TextView) findViewById(R.id.show1);

        Intent Page = getIntent();
        double BMI = Page.getDoubleExtra("BMI",0);
        String TextBmi = Page.getStringExtra("BMItext");



        t.setText(String.format("ค่า BMI ที่ได้คือ %.2f",BMI));
        t1.setText("อยู่ในเกณฑ์ : " + TextBmi);

    }
}
