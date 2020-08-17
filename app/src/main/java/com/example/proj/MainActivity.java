package com.example.proj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureObject = new GestureDetectorCompat(this,new LearnGesture());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent event1,MotionEvent event2,float velocityX,float velocityY){
            if(event2.getX() > event1.getX()){
                finish();
                openActivity2();

            }
            else if (event2.getX() < event1.getX()){


            }
            return true;
        }

    }

    public void openActivity2() {
        Intent startNewActivity = new Intent(this, Activity2.class);
        startActivity(startNewActivity);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
