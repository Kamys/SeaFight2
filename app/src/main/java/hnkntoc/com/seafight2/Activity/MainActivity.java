package hnkntoc.com.seafight2.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hnkntoc.com.seafight2.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPlanningActivity(View view){
        Intent intent = new Intent(this,PlanningActivity.class);
        startActivity(intent);
    }
}
