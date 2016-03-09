package com.example.tommyahav.androidfinal;

import android.util.Log;

/**
 * Created by TomGoldberg on 8.3.16.
 */
public class group_users {
    private static final String LOG = "group_users";
    private static int _indexCounter = 0;


    private static int []KEY_userID ;
    private group _groupID;

    public group_users(group _groupID, user _userID) {
        this._groupID = _groupID;
        for ( int i : KEY_userID ) {
            if (this.KEY_userID[_indexCounter] == _groupID.get_groupID()) break;
            else {
                try{ this.KEY_userID[_indexCounter++] = _userID.get_userID(); }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
                Log.i(LOG, "group was created with values : " + this.toString());
                System.out.println("group was created with values : " + this.toString());
            }
        }
    }

    public group get_groupID() {
        return _groupID;
    }

    public void set_groupID(group _groupID) {
        this._groupID = _groupID;
    }

    public static int get_indexCounter() {
        return _indexCounter;
    }

    public static void set_indexCounter(int _indexCounter) {
        group_users._indexCounter = _indexCounter;
    }

    public static int[] getKEY_userID() {
        return KEY_userID;
    }

    public static void setKEY_userID(int[] KEY_userID) {
        group_users.KEY_userID = KEY_userID;
    }
}
