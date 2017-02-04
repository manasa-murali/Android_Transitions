package com.example.manasa_pt1119.testtransitions;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
AnimatorSet mSetRightOut,mSetLeftIn;
    RelativeLayout relativeLayout;
    Button nextButton,fadeInButton,pushToTopButton;
    Animation animationFadeIn;
    View screen1View,screen2View;
    private boolean mIsBackVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=new RelativeLayout(this);
        relativeLayout=(RelativeLayout)findViewById(R.id.screen1);
        nextButton=new Button(this);
        nextButton=(Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(this);
        fadeInButton=new Button(this);
        fadeInButton=(Button)findViewById(R.id.fadeinButton);
        fadeInButton.setOnClickListener(this);
        pushToTopButton=new Button(this);
        pushToTopButton=(Button)findViewById(R.id.pushToTop);
        pushToTopButton.setOnClickListener(this);



    }
    public void overrideTransitionRotate()
    {
        findViews();
        loadAnimations();
        changeCameraDistance();
        flipCard();
    }
    public void flipCard() {
        if (!mIsBackVisible) {
            mSetRightOut.setTarget(screen1View);
            mSetLeftIn.setTarget(screen2View);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
        } else {
            mSetRightOut.setTarget(screen2View);
            mSetLeftIn.setTarget(screen1View);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }
    }
    public void findViews() {
        screen2View = findViewById(R.id.screen2);
         screen1View= findViewById(R.id.screen2);
    }
    public void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);
    }
public void overrideTransitionFade()
{
    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
}
    public void overrideTransitionSlideEnter()
    {
        overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
    }
    public void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
       }
public void overrideTransitionPushToTop()
{
    overridePendingTransition(R.anim.pull_up_from_bottom, R.anim.hold);
}
    @Override
    public void onClick(View view) {

        Button button=(Button)view;
        Intent nextPage=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(nextPage);
        if(button.getText().equals("Slide in")) {
            overrideTransitionSlideEnter();
        }
        else if(button.getText().equals("Fade In"))
        {
                overrideTransitionFade();
        }
        else if(button.getText().equals("Rotate to right"))
        {
            overrideTransitionRotate();
        }
        else if(button.getText().equals("Push to top"))
        {
            overrideTransitionPushToTop();
        }

    }
}
