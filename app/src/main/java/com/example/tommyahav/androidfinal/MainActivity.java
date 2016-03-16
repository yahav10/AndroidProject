package com.example.tommyahav.androidfinal;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class MainActivity extends AppCompatActivity {

    private static final String LOG = "MainActivity LOG ->";
    private EditText _emailTextView;
    private EditText _passwordTextView;

    private View mProgressView;
    private Button _logInView;


    private boolean verEmail = false;
    private boolean verPass = false;

    DatabaseHelper _myTaskDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG, "MainActivity onCreate()");

        _myTaskDB = new DatabaseHelper(this);

        _emailTextView = (EditText) findViewById(R.id.email_login);
        _passwordTextView = (EditText) findViewById(R.id.password_login);
        _logInView = (Button) findViewById(R.id.loginBottun);

        _emailTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    verifyEmail();
                }
            }
        });

        _passwordTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    verifyPassword();
                }
            }
        });

        //logInButton event listener
        //Button logInButton = (Button)findViewById(R.id.loginBottun);
        _logInView.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("logInButton was clicked");
                if ( verPass && verEmail ) {
                    attemptToLogIn();
                    System.out.println("verPass && verEmail is good");
                }
                else {
                    _logInView.setError("Some error");
                    Snackbar.make( MainActivity.this.findViewById(R.id.Login1mainLayout ) , "Please provide your Email and Password", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        //signUpButton event listener
        Button signUpButton = (Button) findViewById(R.id.signUp_button);
        signUpButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("signUpButton was clicked");
                Intent to_managerSignUp = new Intent(getApplicationContext(), managerSignUp.class);
                startActivity(to_managerSignUp);
            }
        });


        // [Optional] Power your app with Local Datastore. For more info, go to
        // https://parse.com/docs/android/guide#local-datastore
        Parse.enableLocalDatastore(this);
        Parse.initialize(this);

        //Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParseUser.enableRevocableSessionInBackground();

        //TestObject
        //ParseObject user = new ParseObject("User");



        //ParseObject user = new ParseObject("User");
        ParseUser user = new ParseUser();

        user.setUsername("Tom Goldberg12");
        user.setPassword("1234");
        user.setEmail("b@gmail.com");
        //user.put("manager" , true);

        user.signUpInBackground(new SignUpCallback()
        {
            public void done(ParseException e)
            {
                //showProgress(false);
                if (e == null)
                {
                    // Hooray! Let them use the app now.
                    Snackbar.make(MainActivity.this.findViewById(R.id.Login1mainLayout), "Success", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    //Intent intent = new Intent(SignUpActivity.this, CreateTeamActivity.class);
                    //intent.putExtra("password", password);
                    //startActivity(intent);
                    //finish();
                } else
                {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Snackbar.make(MainActivity.this.findViewById(R.id.Login1mainLayout), e.getMessage(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    System.out.println("PPP -> "+e.getMessage());
                }
            }
        });
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(LOG , "onStart()");
        System.out.println("onStart()");
    }


    @Override
    protected void onRestart() {
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
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG , "onDestroy()");
        System.out.println("onDestroy()");
    }


    private void verifyEmail(){
        String emailToCheck = _emailTextView.getText().toString();
        if (  TextUtils.isEmpty(emailToCheck) || hasNoLetters(emailToCheck) ){
            _emailTextView.setError("Please Provide Your Email Address");
            System.out.println("verifyEmail -> 1");
            verEmail = false;
        }
//        else if(  TextUtils.isDigitsOnly(emailToCheck)  ) {
//            _emailTextView.setError("Email Address Only");
//            verEmail = false;
//        }
        else {
            System.out.println("verifyEmail -> 2");
            try{
                _logInView.setError(null);
                verEmail = true ;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    private void verifyPassword(){
        String passwordToCheck = _passwordTextView.getText().toString();
        if (TextUtils.isEmpty(passwordToCheck)||hasNoLetters(passwordToCheck)){
            _passwordTextView.setError("Please Provide Your Password");
            System.out.println("verifyPassword -> 1");
            verPass = false;
        }
        else {
            try{
                _logInView.setError(null);
                verPass = true;

            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("verifyPassword -> 2");
            }
        }
    }

    private boolean isEmail(String checkIfEmail){
        int length = checkIfEmail.length();
        for ( int i =0 ; i < length ; i++){
            if( checkIfEmail.indexOf('@')>=0 ) return true;
        }
        return false;
    }

    private boolean hasNoLetters(String hasNoLettersToCheck){
        if( hasNoLettersToCheck==null || hasNoLettersToCheck.length()==0) return true;
        return false;
    }


    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;


    public void loadImagefromGallery(View view) {
            // Create intent to Open Image applications like Gallery, Google Photos
            Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            // Start the Intent
            startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            try {
                // When an Image is picked
                if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                        && null != data) {
                    // Get the Image from data

                    Uri selectedImage = data.getData();
                    String[] filePathColumn = { MediaStore.Images.Media.DATA };

                    // Get the cursor
                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imgDecodableString = cursor.getString(columnIndex);
                    cursor.close();
                    ImageView imgView = (ImageView) findViewById(R.id.imgView);
                    // Set the Image in ImageView after decoding the String
                    imgView.setImageBitmap(BitmapFactory
                            .decodeFile(imgDecodableString));

                } else {
                    Toast.makeText(this, "You haven't picked Image",
                            Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                        .show();
            }

        }


    private void attemptToLogIn(){
        String username = _emailTextView.getText().toString();
        String password = _passwordTextView.getText().toString();
        //showProgress(true);
        System.out.println("username : "+username+", password :"+password);
        ParseUser.logInInBackground( username ,  password , new LogInCallback() {
            public void done(ParseUser user, ParseException e)
            {
                //showProgress(false);
                if (user != null)
                {
                    System.out.println("user != null");
                    // Hooray! The user is logged in.
                    final boolean manager = user.getBoolean("manager");
                    System.out.println("manager : " + manager);
                    //boolean is_active = user.getBoolean("is_active");
                    if (manager)
                    {
                        Snackbar.make(MainActivity.this.findViewById(R.id.Login1mainLayout), "success", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        Intent intent = new Intent(MainActivity.this, manager_menu.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
//                        if  (is_active)
//                        {
//                            Snackbar.make(LoginActivity.this.findViewById(R.id.root_view), R.string.logged_in_success, Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                            Intent intent = new Intent(LoginActivity.this, UserTasksActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                        else
//                        {
//                            Snackbar.make(LoginActivity.this.findViewById(R.id.root_view), R.string.logged_in_success, Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                            Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
                    }

                } else
                {
                    Snackbar.make(MainActivity.this.findViewById(R.id.Login1mainLayout), "!! "+e.getMessage(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });


    }
}
