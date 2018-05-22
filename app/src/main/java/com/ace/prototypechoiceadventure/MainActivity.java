package com.ace.prototypechoiceadventure;

import android.content.Intent;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnFragmentButtonListener {
    FrameLayout container;
    DulFragment dulFragment;
    Dul2Fragment dul2Fragment;
    SamFragment samFragment;
    Sam2Fragment sam2Fragment;
    Sam3Fragment sam3Fragment;
    Sam4Fragment sam4Fragment;
    HanaFragment hanaFragment;
    ImageView iv_menuButton;
    FrameLayout fl_menu;
    Animation up,down;
    boolean isPageVisible = false;
    public static final String SAVED_STATE = "saved";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
           Fragment fragment =  (Fragment) savedInstanceState.getParcelable(SAVED_STATE);
           getSupportFragmentManager().beginTransaction()
                   .replace(R.id.fl_container, fragment)
                   .addToBackStack("Present").commit();
            Log.d("SAVEDSTATE", "이쪽으로 들어와라 좀.");
        }
            startFragment();

            iv_menuButton = findViewById(R.id.iv_menuButton);
            fl_menu = findViewById(R.id.fl_menu);
            up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
            down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
            startImageViewButton();


    }




    private void startImageViewButton() {
        iv_menuButton.setOnClickListener(new View.OnClickListener() {
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
                        .replace(R.id.fl_container, dulFragment)
                        .addToBackStack("Dul").commit();

                break;

            case 2:
                dul2Fragment = new Dul2Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,dul2Fragment)
                        .addToBackStack("Dul2").commit();

                break;

            case 3:
                samFragment = new SamFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,samFragment)
                        .addToBackStack("Sam").commit();
                break;
            case 4:
                sam2Fragment = new Sam2Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,sam2Fragment)
                        .addToBackStack("Sam2").commit();

                break;
            case 5:
                sam3Fragment = new Sam3Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,sam3Fragment)
                        .addToBackStack("Sam3").commit();
                break;
            case 6:
                sam4Fragment = new Sam4Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,sam4Fragment)
                        .addToBackStack("Sam4").commit();
                break;


        }
    }

    private void startFragment(){
        hanaFragment = new HanaFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container,hanaFragment)
                .commit();
    }

    @Override
    protected void onPause() {
        Parcelable curFragment = (Parcelable) getSupportFragmentManager().findFragmentById(R.id.fl_container);
        Bundle outState = new Bundle();
        outState.putParcelable(SAVED_STATE,curFragment);

        onSaveInstanceState(outState);
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

