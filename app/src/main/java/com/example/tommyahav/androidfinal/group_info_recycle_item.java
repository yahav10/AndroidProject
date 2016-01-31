package com.example.tommyahav.androidfinal;

/**
 * Created by TomGoldberg on 18.1.16.
 */
public class group_info_recycle_item {
    private int _personPic;
    private String _personH1;
    private String _personH2;
    private int _personThumbnail;

    //public group_info_recycle_item(){};

//    public group_info_recycle_item(String personH1, String personH2, int personPic, int personThumbnail) {
//        this._personH1 = personH1;
//        this._personH2 = personH2;
//        this._personPic = personPic;
//        this._personThumbnail = personThumbnail;
//        System.out.println("New Recycler item :" + this.toString());
//    }

    public String getPersonH1() {
        return this._personH1;
    }

    public void setPersonH1(String personH1) {
        this._personH1 = personH1;
    }

    public String getPersonH2() {
        return this._personH2;
    }

    public void setPersonH2(String personH2) {
        this._personH2 = personH2;
    }

    public int getPersonPic() {
        return this._personPic;
    }

    public void setPersonPic(int personPic) {
        this._personPic = personPic;
    }

    public int getPersonThumbnail() {
        return _personThumbnail;
    }

    public void setPersonThumbnail(int personThumbnail) {
        this._personThumbnail = personThumbnail;
    }

    @Override
    public String toString() {
        return "group_info_recycle_item{" +
                "personH1='" + this._personH1 + '\'' +
                ", personPic=" + this._personPic +
                ", personH2='" + this._personH2 + '\'' +
                ", personThumbnail=" + this._personThumbnail +
                '}';
    }
}
