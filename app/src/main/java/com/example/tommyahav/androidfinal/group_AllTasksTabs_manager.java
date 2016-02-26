package com.example.tommyahav.androidfinal;


        //import androidarena.tab.R;

        import android.os.Bundle;
        import android.app.ActionBar;
        import android.app.FragmentTransaction;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.view.ViewPager;
        import android.widget.Toast;

public class group_AllTasksTabs_manager extends FragmentActivity {
    ViewPager Tab;
    TabPagerAdapter TabAdapter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group__all_tasks_tabs_manager);

        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());


        Tab = (ViewPager)findViewById(R.id.pager);

        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {

                        actionBar = getActionBar();
                        actionBar.setSelectedNavigationItem(position);                    }
                });

        Tab.setAdapter(TabAdapter);

        actionBar = getActionBar();

        //Enable Tabs on Action Bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){

            @Override
            public void onTabReselected(android.app.ActionBar.Tab tab,
                                        FragmentTransaction ft) {
                // TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), "Tab selected").show();

            }

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

                Tab.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(android.app.ActionBar.Tab tab,
                                        FragmentTransaction ft) {
                // TODO Auto-generated method stub

            }};
        //Add New Tabs
        actionBar.addTab(actionBar.newTab().setText("Movie").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Music").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Video").setTabListener(tabListener));

    }




}
