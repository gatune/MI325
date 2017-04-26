package com.example.max.bmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    Button cal ;
    private Spinner act1 ;
    private Spinner goal1;
    EditText age1,weight1,height1 ;
    String[] actData = {"SEDENTARY (NO EXERCISE)","LIGHTLY ACTIVE (1-3 DAYS/WEEK)","LIGHTLY ACTIVE (1-3 DAYS/WEEK)"
            ,"VERY ACTIVE (6-7 DAYS/WEEK)","EXTREMELY ACTIVE (TWICE DAILY)"};
    String[] goalData = {"LOSE FAT","MAINTAIN","GAIN WEIGHT"};
    String actSelected;
    String goalSelected;
    double BMR ,TDEE ,ALL ;
    double a,w,h;
    RadioButton cmail,cfemale;


    private void chooseAct () {
      TDEE = Double.parseDouble(actData.getClass().toString());
      if (actSelected == "SEDENTARY (NO EXERCISE)") {
          TDEE = 1.2 * BMR;

      } else if (actSelected == "LIGHTLY ACTIVE (1-3 DAYS/WEEK)") {
          TDEE = 1.375 * BMR;

      } else if (actSelected == "LIGHTLY ACTIVE (1-3 DAYS/WEEK)") {
          TDEE = 1.55 * BMR;

      } else if (actSelected == "VERY ACTIVE (6-7 DAYS/WEEK)") {
          TDEE = 1.7 * BMR;

      }   else if (actSelected == "EXTREMELY ACTIVE (TWICE DAILY)") {
          TDEE = 1.9 * BMR;
      }

  }

    private void chooseGoal () {
        ALL = Double.parseDouble(goalData.getClass().toString());
        if (goalSelected == "LOSE FAT") {
            ALL = TDEE-500;

        } else if (goalSelected == "MAINTAIN") {
            ALL = TDEE+500;

        } else if (goalSelected == "GAIN WEIGHT") {
            ALL = TDEE;
        }

    }

    public void calBMR () {
        a = Double.parseDouble(age1.getText().toString());
        w = Double.parseDouble(weight1.getText().toString());
        h = Double.parseDouble(height1.getText().toString());



    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        cal = (Button) findViewById(R.id.calculate);
        cal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent newActivity = new Intent(Activity2.this,Activity3.class);
                startActivity(newActivity);
            }
        });
        act1 = (Spinner)findViewById(R.id.act);
        ArrayAdapter<String> adapterAct = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, actData);
        adapterAct.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        act1.setAdapter(adapterAct);

        goal1 =(Spinner)findViewById(R.id.goal);
        ArrayAdapter<String> adapterGoal = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, goalData);
        adapterGoal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goal1.setAdapter(adapterGoal);

        age1 = (EditText)findViewById(R.id.age);
        weight1 = (EditText)findViewById(R.id.weight);
        height1 = (EditText)findViewById(R.id.height);
        cmail = (RadioButton)findViewById(R.id.male);
        cfemale = (RadioButton)findViewById(R.id.female);
    }


}
