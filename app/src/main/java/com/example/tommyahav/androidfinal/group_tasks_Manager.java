package com.example.tommyahav.androidfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class group_tasks_Manager extends AppCompatActivity {

    private static final String TAG = "group_tasks_Manager";

    private List<group_info_recycle_item> feedItemList = new ArrayList<>();

    private RecyclerView mRecyclerView;

    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_tasks_manager);
        //recyclerView = (RecyclerView)findViewById(R.id.listView2);

        /* Initialize recyclerview */
        mRecyclerView = (RecyclerView) findViewById(R.id.listView_groupTasks_Manager);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        feedItemList = initialFeedListItem(feedItemList);
        optionOne();
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

    public List<group_info_recycle_item>  initialFeedListItem(List<group_info_recycle_item>  feedItemList){
        for ( int i = 0 ; i < 10 ; i++ ) {
            group_info_recycle_item one = new group_info_recycle_item();
            one.setPersonPic(R.mipmap.image_1);
            one.setPersonH1(i + " one h1 text");
            one.setPersonH2(i + " one h2 text");
            one.setPersonThumbnail(R.mipmap.ic_launcher);
            feedItemList.add(one);
        }
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
