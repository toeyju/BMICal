package com.example.bmical;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    Button calculate;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height_edit_text);
        weight = (EditText) findViewById(R.id.weight_edit_text);
        calculate = (Button) findViewById(R.id.calculate_button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height1 = Double.valueOf(height.getText().toString());
                double weight1 = Double.valueOf(weight.getText().toString());
                double bmi = weight1 / ((height1 / 100) * (height1 / 100));

                 String bmiText=" ";
                if (bmi < 18.5){
                    bmiText = "น้ำหนักน้อยกว่าปกติ";
                }else if(bmi < 25){
                    bmiText = "น้ำหนักปกติ";
                }else if (bmi < 30) {
                    bmiText = "น้ำหนักมากกว่าปกติ (ท้วม)";
                }else{
                    bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
                }
                Intent NewPage = new Intent(MainActivity.this,Main2Activity.class);
                NewPage.putExtra("BMI",bmi);
                NewPage.putExtra("BMItext",bmiText);
                startActivity(NewPage);

                /*String bmiText = getBmiText(bmi);
                String result = String.format("ค่า BMI ที่ได้ %.2f\n\nอยู่ในเกณฑ์ : %s",bmi,bmiText);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this); // จำ
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });*/
               // dialog.show();
            }
        });
    }
   /* private String getBmiText (Double bmi){
            String bmiText;
        if (bmi < 18.5){
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        }else if(bmi < 25){
            bmiText = "น้ำหนักปกติ";
        }else if (bmi < 30) {
            bmiText = "น้ำหนักมากกว่าปกติ (ท้วม)";
        }else{
            bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return bmiText;
    }*/
}

