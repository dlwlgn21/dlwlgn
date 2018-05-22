package com.ace.prototypechoiceadventure;

import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements OnFragmentButtonListener {
    FrameLayout container;
    DulFragment dulFragment;
    Dul2Fragment dul2Fragment;
    ImageView iv_menubutton;
    FrameLayout fl_menu;
    Animation up,down;
    boolean isPageVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFragment();
        iv_menubutton = findViewById(R.id.iv_menuButton);
        fl_menu = findViewById(R.id.fl_menu);
        up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);

        startImageViewButton();


    }

    private void startImageViewButton() {
        iv_menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageVisible == false){
                    fl_menu.startAnimation(up);
                    fl_menu.setVisibility(View.VISIBLE);
                    isPageVisible = true;
                }else{
                    fl_menu.startAnimation(down);
                    fl_menu.setVisibility(View.INVISIBLE);
                    isPageVisible = false;
                }
            }
        });
    }

    @Override
    public void onFragmentButtonClicked(int position) {
        switch (position){

            case 1:
                dulFragment = new DulFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container, dulFragment).commit();
                break;

            case 2:
                dul2Fragment = new Dul2Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,dul2Fragment).commit();
                break;

            case 3:

                break;

            case 4:

                break;
            case 5:

                break;

            case 6:

                break;
        }
    }

    private void startFragment(){
        HanaFragment hanaFragment = new HanaFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container,hanaFragment).commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}

