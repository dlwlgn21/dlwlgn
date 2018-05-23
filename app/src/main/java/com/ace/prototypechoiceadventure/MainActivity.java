package com.ace.prototypechoiceadventure;


import android.os.AsyncTask;


import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements OnFragmentButtonListener {
    FrameLayout container;
    FrameLayout fl_startActive;
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
    public static final String SAVED_PERSISTANCE_FILE = "saved_fille";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            Log.d("onCreate()","들어와서 불러오기 수행!!");
            Fragment fragment = (Fragment) savedInstanceState.getSerializable(SAVED_STATE);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_container,fragment).commit();

        }

        fl_startActive = findViewById(R.id.fl_startActive);
        findViewById(R.id.bt_newGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl_startActive.setVisibility(View.INVISIBLE);
                startFragment();
            }
        });
        findViewById(R.id.bt_loadGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl_startActive.setVisibility(View.INVISIBLE);
                readFileForFragment();
            }
        });
        findViewById(R.id.bt_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
                if(!isPageVisible){
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
                        .commit();

                break;

            case 2:
                dul2Fragment = new Dul2Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,dul2Fragment)
                        .commit();

                break;

            case 3:
                samFragment = new SamFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,samFragment)
                        .commit();
                break;
            case 4:
                sam2Fragment = new Sam2Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,sam2Fragment)
                        .commit();

                break;
            case 5:
                sam3Fragment = new Sam3Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,sam3Fragment)
                        .commit();
                break;
            case 6:
                sam4Fragment = new Sam4Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,sam4Fragment)
                        .commit();
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
        Fragment curFragment =getSupportFragmentManager().findFragmentById(R.id.fl_container);
        Bundle outState = new Bundle();
        outState.putSerializable(SAVED_STATE, (Serializable) curFragment);
        onSaveInstanceState(outState);
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        AsyncForFileWrite writeTask = new AsyncForFileWrite();
        writeTask.execute();
        super.onStop();
    }



    private void readFileForFragment(){
       AsyncForFileRead readTask = new AsyncForFileRead();
       readTask.execute();
    }

    class AsyncForFileWrite extends AsyncTask<Void, Void, Void>{
        Object lastFragment;
        @Override
        protected void onPreExecute() {
            lastFragment = getSupportFragmentManager().findFragmentById(R.id.fl_container);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Log.d("AsyncForFileWrite","들어왔음.");
                FileOutputStream fos = openFileOutput(SAVED_PERSISTANCE_FILE,MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(lastFragment);
                Log.d("AsyncForFileWrite","파일 썼음.");
                oos.flush();
                oos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
    class AsyncForFileRead extends AsyncTask<Void, Void, Fragment>{
        Fragment lastFragment;
        @Override
        protected Fragment doInBackground(Void... voids) {
            try {
                Log.d("AsyncForFileRead","들어왔음.");
                FileInputStream fis = openFileInput(SAVED_PERSISTANCE_FILE);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object object = ois.readObject();
                Log.d("AsyncForFileRead","파일읽었음.");
                lastFragment = (Fragment) object;
                Log.d("AsyncForFileRead","파일 불러왔음. : "+lastFragment.toString());
                ois.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }

            return lastFragment;
        }

        @Override
        protected void onPostExecute(Fragment fragment) {
            super.onPostExecute(fragment);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_container,fragment)
                    .commit();
        }
    }
}

