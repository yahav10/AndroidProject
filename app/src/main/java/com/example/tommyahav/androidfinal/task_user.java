package com.example.tommyahav.androidfinal;

import android.util.Log;

/**
 * Created by TomGoldberg on 9.3.16.
 */
public class task_user {
    private static final String LOG = "task_user";
    private static int _indexCounter = 0;

    private static task []KEY_taskID;
    //private static int []KEY_taskID ;
    private user _userID;
    //private int _userID;

    public task_user(task task_temp, user user_temp) {
        _indexCounter = KEY_taskID.length;
        this._userID = user_temp;
        for ( int i = 0 ; i < KEY_taskID.length ; i++ ) {
            if (  this.KEY_taskID[ i ].get_taskId() == task_temp.get_taskId() ) break;

            //else {
                try{    this.KEY_taskID[_indexCounter++] = task_temp ;  }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
                Log.i(LOG, "task_user was created with values : " + this.toString());
                System.out.println("task_user was created with values : " + this.toString());
            //}
        }
    }

    public static int get_indexCounter() {
        return _indexCounter;
    }

    public static void set_indexCounter(int _indexCounter) {
        task_user._indexCounter = _indexCounter;
    }

    public static task[] getKEY_taskID() {
        return KEY_taskID;
    }

    public static void setKEY_taskID(task[] KEY_taskID) {
        task_user.KEY_taskID = KEY_taskID;
    }

    public user get_userID() {
        return _userID;
    }

    public void set_userID(user _userID) {
        this._userID = _userID;
    }
}
