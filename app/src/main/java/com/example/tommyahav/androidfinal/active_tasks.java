package com.example.tommyahav.androidfinal;

/**
 * Created by TomGoldberg on 25.2.16.
 */

//        import androidarena.tab.R;
//        import androidarena.*;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

public class active_tasks extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mov = inflater.inflate(R.layout.alltasks_active, container, false);
        ((TextView)mov.findViewById(R.id.textView)).setText("Movies List");
        return mov;
    }
}
