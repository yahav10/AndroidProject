package com.example.tommyahav.androidfinal;

/**
 * Created by TomGoldberg on 20.12.15.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class managerSignUp extends AppCompatActivity {

    private static final String LOG = "managerSignUp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_uplayout);
        Log.i(LOG, "onCreate()");

        //logInButton event listender
//        Button logInButton = (Button)findViewById(R.id.managerSignUpButton);
//        logInButton.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                System.out.println("logInButton was clicked");
//            }
//        });

        //managerSignUpButton event listener
        Button createAccountButton = (Button)findViewById(R.id.addMemberButton_fromInviteMembers);
        createAccountButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("managerSignUpButton was clicked");
                Intent intent = new Intent(getApplicationContext(), managerInviteFriends.class);
                startActivity(intent);
            }
        });
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        Log.i(LOG, "onOptionsItemSelected()");
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(LOG , "onStart()");
        System.out.println("onStart()");
    }


    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(LOG , "onRestart()");
        System.out.println("onRestart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(LOG , "onResume()");
        System.out.println("onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(LOG , "onPause()");
        System.out.println("onPause()");
    }


    @Override
    protected void onStop(){
        super.onStop();
        Log.i(LOG , "onStop()");
        System.out.println("onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(LOG , "onDestroy()");
        System.out.println("onDestroy()");
    }

}
