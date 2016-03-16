package com.example.tommyahav.androidfinal;

/**
 * Created by TomGoldberg on 20.12.15.
 */

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class managerSignUp extends AppCompatActivity {

    private static final String LOG = "managerSignUp";
    DatabaseHelper SignUp_db  = MainActivity._myDB;
    private EditText etEmail , etUsername , etPassword , etUserGroup , etUserPhone;
    private Cursor _USERMaxID;

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
        //SignUp_db = new DatabaseHelper(this);


        etEmail = (EditText)findViewById(R.id.email_signup);
        etUsername = (EditText)findViewById(R.id.userName);
        etPassword = (EditText) findViewById(R.id.password_signup);
        etUserPhone = (EditText)findViewById(R.id.phone_signup);
        etUserGroup = (EditText)findViewById(R.id.groupName_signup);

        //managerSignUpButton event listener
        Button createAccountButton = (Button)findViewById(R.id.createAccountButton_activity_sign_up);
        createAccountButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("managerSignUpButton was clicked");

                String sEmail = etEmail.getText().toString();
                String sUserName = etUsername.getText().toString();
                String sPassword = etPassword.getText().toString();
                String sUserPhone = etUserPhone.getText().toString();
                String sUserGroup = etUserGroup.getText().toString();
                System.out.println(sEmail);
                System.out.println(sUserName);
                System.out.println(sPassword);
                System.out.println(sUserPhone);
                System.out.println(sUserGroup);

                try{

                    _USERMaxID = SignUp_db.getMaxID_fromUserTable();
                    //if( _USERMaxID.getCount() == 0 ){
                        System.out.println("The is now rows -> creating new instance of manager");
                        Log.i(LOG, " The is now rows -> creating new instance of manager");
                        StringBuffer buffer = new StringBuffer();
                        while(_USERMaxID.moveToNext()){
                            buffer.append(_USERMaxID.getString(0));
                            //System.out.println("The max number is  : " + buffer.toString());
                        }
                    int _updatedMaxID = Integer.parseInt(buffer.toString());
                    _updatedMaxID++;
                    String _updatedMaxID_asString = _updatedMaxID+"";
                   // }

                    boolean insert = SignUp_db.insertRowToUsersLocalDB(_updatedMaxID_asString, sUserName, sPassword, sEmail, "true", sUserPhone, sUserGroup);
                     if( insert==true ){
                         Toast toast = Toast.makeText(managerSignUp.this , sUserName+" is a new manager", Toast.LENGTH_SHORT);
                         toast.show();
                         Intent intent = new Intent( managerSignUp.this , managerInviteFriends.class );
                         startActivity(intent);
                     } else {
                    System.out.println("Unable to insert new User!");
                     }
                }
                catch(Exception e){
                    System.out.println("Was Unable to insert to User DataBase ->"+e.getMessage());
                }


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
