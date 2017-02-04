package com.example.manasa_pt1119.testtransitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by manasa-pt1119 on 03/02/17.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    public SecondActivity(){}
    RelativeLayout relativeLayout2;
    Button prevButton,fadeOutButton,pushToBottomButton;
    View view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        relativeLayout2=new RelativeLayout(this);
        relativeLayout2=(RelativeLayout)findViewById(R.id.screen2);
        prevButton=new Button(this);
        prevButton=(Button)findViewById(R.id.prevButton);
        prevButton.setOnClickListener(this);
        fadeOutButton=new Button(this);
        fadeOutButton=(Button)findViewById(R.id.fadeoutButton);
        fadeOutButton.setOnClickListener(this);
        pushToBottomButton=new Button(this);
        pushToBottomButton=(Button)findViewById(R.id.pushToBottom);
        pushToBottomButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(view instanceof Button) {
            Button button = (Button) view;
            if (button.getText().equals("Slide out")) {
                overrideTransitionSlideExit();

            }
            else if(button.getText().equals("Fade Out"))
            {
                overrideTransitionFadeOut();
            }
            else if(button.getText().equals("Push to bottom"))
            {
                overrideTransitionPushToBottom();
            }
        }else {super.onBackPressed();}
    }
    public void overrideTransitionPushToBottom()
    {
        overridePendingTransition(R.anim.hold,R.anim.pull_down_from_top);
    }
    public void overrideTransitionFadeOut()
    {
        overridePendingTransition(R.anim.fade_out,R.anim.fade_in);
    }
public void overrideTransitionSlideExit()
{
    overridePendingTransition(R.transition.slide_from_left,R.transition.slide_to_right);
}

    @Override
    public void onClick(View view) {
        this.view=view;
        onBackPressed();

    }

}
