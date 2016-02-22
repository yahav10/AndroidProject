package com.example.tommyahav.androidfinal;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class group_info_Manager extends Activity {

    private static final String TAG = "RecyclerViewExample";

    private List<group_info_recycle_item> feedItemList = new ArrayList<>();

    private RecyclerView mRecyclerView;

    private MyRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info__manager);

        /* Allow activity to show indeterminate progressbar */
        //requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        /* Initialize recyclerview */
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_group_info);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        /*Downloading data from below url*/
        //final String url = "http://javatechig.com/api/get_category_posts/?dev=1&slug=android";

        //System.out.println("The String url is : " + url);
        //System.out.println("The length of the string is : " + url.length());

        //new AsyncHttpTask().execute(url);


        feedItemList = initialFeedListItem(feedItemList);
        optionOne();

    }


//    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
//        View layout = inflater.inflate(R.layout.activity_group_info__manager , container , false);
//        recyclerView=(RecyclerView)findViewById(R.id.recycle_group_info);
//        myAdapter = new MyRecyclerAdapter(    this.getData()   );
//        recyclerView.setAdapter(myAdapter);
//        //recyclerView.setLayoutManager(new LinearLayoutManager(());
//        return layout;
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_group_info__manager, menu);
//        return true;
//
//    }

//    public static List<group_info_recycle_item> getData() {
//        List<group_info_recycle_item> data = new ArrayList<>();
//        int itemPersonPics = (R.drawable.logonew1);
//        String itemsH1 = "Initial Text";
////        for ( int i=0 ; i<itemPersonPics.length && i<itemsH1.length ; i++){
//        group_info_recycle_item current = new group_info_recycle_item(itemPersonPics,itemsH1);
//        //current.set_num(itemPersonPics);
//        //current.set_h1(itemsH1);
//        data.add(current);
////    }
//        return data;
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
            adapter = new MyRecyclerAdapter( group_info_Manager.this  , feedItemList);
            mRecyclerView.setAdapter(adapter);
        }

        else {
            Log.e(TAG, "Failed to fetch data!");
        }
    }
}
