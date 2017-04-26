package com.example.max.bmr;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.next2);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent newActivity = new Intent(MainActivity.this,Activity2.class);
                startActivity(newActivity);
            }
        });
    }
}
