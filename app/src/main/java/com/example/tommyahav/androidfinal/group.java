package com.example.tommyahav.androidfinal;

import android.util.Log;

/**
 * Created by TomGoldberg on 8.3.16.
 */
public class group {
    private static final String LOG = "group";
    private static int _AllgroupsID = 201;

    private int _groupID ;
    private String _groupName;

    public group(String groupName){
        this._groupID = _AllgroupsID++;
        this._groupName = groupName;
        Log.i(LOG, "Default constructor -> group was created with values : " + this.toString());
        System.out.println("group was created with values : "+this.toString());
    }

    public group(String groupName , int groupID){
        this._groupID = groupID;
        this._groupName = groupName;
        Log.i(LOG, "group was created with values : " + this.toString());
        System.out.println("group was created with values : "+this.toString());
    }



    public static int get_AllgroupsID() {
        return _AllgroupsID;
    }

    public static void set_AllgroupsID(int _AllgroupsID) {
        group._AllgroupsID = _AllgroupsID;
    }

    public int get_groupID() {
        return _groupID;
    }

    public void set_groupID(int _groupID) {
        this._groupID = _groupID;
    }

    public String get_groupName() {
        return _groupName;
    }

    public void set_groupName(String _groupName) {
        this._groupName = _groupName;
    }
}
