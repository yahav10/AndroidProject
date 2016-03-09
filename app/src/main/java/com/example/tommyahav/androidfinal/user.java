package com.example.tommyahav.androidfinal;

import android.util.Log;

/**
 * Created by TomGoldberg on 8.3.16.
 */
public class user {
    private static final String LOG = "user";
    private static int _AllusersID = 101;

    private int _userID ;
    private String _userName;
    private String _userMail;
    private int _userPic = R.mipmap.image_1; // default user pic
    private String  _userPhone = "972504224341";

    public user ( String userName , String userMail ){
        this._userID = _AllusersID++;
        this._userName = userName;
        this._userMail = userMail;
        Log.i(LOG, "default constructor of user was executed");
        System.out.println("default constructor of user was executed ->"+this.toString());
    }

    @Override
    public String toString() {
        return "user{" +
                "_userID=" + _userID +
                ", _userName='" + _userName + '\'' +
                ", _userMail='" + _userMail + '\'' +
                ", _userPic=" + _userPic +
                ", _userPhone=" + _userPhone +
                '}';
    }

    public int get_userID() {
        return _userID;
    }

    public void set_userID(int _userID) {
        this._userID = _userID;
    }

    public String get_userMail() {
        return _userMail;
    }

    public void set_userMail(String _userMail) {
        this._userMail = _userMail;
    }

    public String get_userName() {
        return _userName;
    }

    public void set_userName(String _userName) {
        this._userName = _userName;
    }

    public String get_userPhone() {
        return _userPhone;
    }

    public void set_userPhone(String _userPhone) {
        this._userPhone = _userPhone;
    }

    public static int get_AllusersID() {
        return _AllusersID;
    }

    public static void set_AllusersID(int _AllusersID) {
        user._AllusersID = _AllusersID;
    }

    public int get_userPic() {
        return _userPic;
    }

    public void set_userPic(int _userPic) {
        this._userPic = _userPic;
    }



}
