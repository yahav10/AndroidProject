package com.example.tommyahav.androidfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class group_info_Manager extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info__manager);

    }


    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
        View layout = inflater.inflate(R.layout.activity_group_info__manager , container , false);
        recyclerView=(RecyclerView)findViewById(R.id.recycle_group_info);
        myAdapter = new MyAdapter(    this.getData()   );
        recyclerView.setAdapter(myAdapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(());
        return layout;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_group_info__manager, menu);
//        return true;
//
//    }

    public static List<group_info_recycle_item> getData() {
        List<group_info_recycle_item> data = new ArrayList<>();
        int itemPersonPics = (R.drawable.logonew1);
        String itemsH1 = "Initial Text";
//        for ( int i=0 ; i<itemPersonPics.length && i<itemsH1.length ; i++){
        group_info_recycle_item current = new group_info_recycle_item(itemPersonPics,itemsH1);
        //current.set_num(itemPersonPics);
        //current.set_h1(itemsH1);
        data.add(current);
//    }
        return data;
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
