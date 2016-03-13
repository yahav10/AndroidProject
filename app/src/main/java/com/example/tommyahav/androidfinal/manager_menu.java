package com.example.tommyahav.androidfinal;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class manager_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_menu);

        //group info event listener
        Button groupInfoButton = (Button) findViewById(R.id.groupInfo_button);
        groupInfoButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("groupInfo_button was clicked");
                Intent to_group_info = new Intent(manager_menu.this, group_info_Manager.class);
                System.out.println("after intent");
                try {
                    startActivity(to_group_info);
                    System.out.println("after startActivity");
                    finish();
                } catch (Exception exception) {
                    System.out.println("error with intent in manager_menu" + exception.getMessage());
                }
            }
        });

        //task list event listener
        Button groupTasksButton = (Button) findViewById(R.id.tasksList_button);
        groupTasksButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("groupTasksButton was clicked");
                Intent to_group_tasks = new Intent(manager_menu.this, group_tasks_Manager.class);
                try {
                    startActivity(to_group_tasks);
                    //finish();
                } catch (Exception exception) {
                    System.out.println("error with intent in manager_menu" + exception.getMessage());
                }
            }
        });

        //create task event listener
        Button createTasksButton = (Button) findViewById(R.id.createTask_button);
        createTasksButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("createTasksButton was clicked");
                Intent to_create_tasks = new Intent(manager_menu.this, create_new_task.class);
                try {
                    startActivity(to_create_tasks);
                    //finish();
                } catch (Exception exception) {
                    System.out.println("error with intent in manager_menu" + exception.getMessage());
                }
            }
        });

//        private class ButtonHandler implements View.OnClickListener {
//            public void onClick(View v) {
//                startActivity(  new Intent( manager_menu.this, group_info_Manager.class)  );
//            }
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manager_menu, menu);
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

}
// Tom
//    public void onNavigationDrawerItemSelected(int position) {
//
//        Fragment objFragment = null;
//
//        switch (position) {
//            case 0:
//                objFragment = new new_fragment1();
//            case 1:
//                objFragment = new new_fragment2();
//            case 2:
//                objFragment = new new_fragment3();
//        }
//        android.app.FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.container,objFragment);
//                .commit();
//    }

