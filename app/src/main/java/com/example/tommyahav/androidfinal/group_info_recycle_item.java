package com.example.tommyahav.androidfinal;

/**
 * Created by TomGoldberg on 18.1.16.
 */
public class group_info_recycle_item {
    private int _num = 0;
    private String _h1 = "";
    //String h2;
    //int icon1, icon2, icon3;
    public group_info_recycle_item (int num , String h1){
        super();
        this._num = num;
        this._h1 = h1;
        System.out.println("New item was created. -> Num="+this._num +", H1="+this._h1);
    }

    public int get_num() {
        return _num;
    }

    public void set_num(int _num) {
        this._num = _num;
    }

    public String get_h1() {
        return _h1;
    }

    public void set_h1(String _h1) {
        this._h1 = _h1;
    }

    @Override
    public String toString() {
        return "group_info_recycle_item{" + "_num=" + this._num +  ", _h1='" + this._h1 + '\'' + '}';
    }
}
