package com.example.tommyahav.androidfinal;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tommyahav on 13/03/2016.
 */
public class new_fragment3 extends Fragment {
        View rootview;
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            rootview = inflater.inflate(R.layout.activity_group_tasks_manager,container,false);
                    return rootview;
    }
}
