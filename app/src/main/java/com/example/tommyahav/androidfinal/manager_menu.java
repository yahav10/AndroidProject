package com.example.tommyahav.androidfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
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


//test!!
        //create test event listener
        Button createTestButton = (Button) findViewById(R.id.groupTasks_button);
        createTestButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("createTestButton was clicked");
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


}
