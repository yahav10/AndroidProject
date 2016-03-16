package com.example.tommyahav.androidfinal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class group_tasks_Manager extends AppCompatActivity {

    private static final String TAG = "group_tasks_Manager";
    private List<group_info_recycle_item> feedItemList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter adapter;
    public DatabaseHelper group_tasks_db ;
    public static Cursor _tasksCursor ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_tasks_manager);
        //recyclerView = (RecyclerView)findViewById(R.id.listView2);

        /* Initialize recycle view */
        mRecyclerView = (RecyclerView) findViewById(R.id.listView_groupTasks_Manager);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        feedItemList = initialFeedListItem(feedItemList);
        optionOne();

        /* move to Create new task activity */
        Button signUpButton = (Button)findViewById(R.id.button1);
        signUpButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Add Button was clicked");
                Intent to_create_new_task = new Intent(group_tasks_Manager.this, create_new_task.class);
                startActivity(to_create_new_task);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_task__list__manager, menu);
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

        return super.onOptionsItemSelected(item);
    }

    public List<group_info_recycle_item>  initialFeedListItem( List<group_info_recycle_item>  feedItemList){
        group_tasks_db  = MainActivity._myDB;
        _tasksCursor = group_tasks_db.getAllTasksToView();
        StringBuffer stringBuffer = new StringBuffer();
        int i= 1;
        while(_tasksCursor.moveToNext()){
            group_info_recycle_item one = new group_info_recycle_item();
            stringBuffer.append(_tasksCursor.getString(1));
            stringBuffer.append(_tasksCursor.getString(3)); //taskName
            stringBuffer.append(_tasksCursor.getString(4)); // taskDescription
            stringBuffer.append(_tasksCursor.getString(5));
            stringBuffer.append(_tasksCursor.getString(6));
            stringBuffer.append(_tasksCursor.getString(7));
            one.setPersonPic(R.mipmap.image_1);
            one.setPersonH1(_tasksCursor.getString(2));
            //one.setPersonH1("hii");
            one.setPersonH2(_tasksCursor.getString(3));
            one.setPersonThumbnail(R.mipmap.ic_launcher);
            feedItemList.add(one);
        }


//        for ( int i = 0 ; i < 10 ; i++ ) {
//            group_info_recycle_item one = new group_info_recycle_item();
//            one.setPersonPic(R.mipmap.image_1);
//            one.setPersonH1(i + " one h1 text");
//            one.setPersonH2(i + " one h2 text");
//            one.setPersonThumbnail(R.mipmap.ic_launcher);
//            feedItemList.add(one);
//        }

        return feedItemList;
    }

    public void optionOne() {
        if(true){
            adapter = new MyRecyclerAdapter( group_tasks_Manager.this  , feedItemList);
            mRecyclerView.setAdapter(adapter);
        }
        else {
            Log.e(TAG, "Failed to fetch data!");
        }
    }
}
