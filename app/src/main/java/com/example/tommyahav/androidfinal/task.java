package com.example.tommyahav.androidfinal;

import android.util.Log;

/**
 * Created by TomGoldberg on 4.3.16.
 */


public class task {
    private static final String LOG = "task";

    private static int _allTasksID = 501;
    private int _taskId;
    private String _taskName;
    private String _taskDescription;
    //private Location _taskLocation;
    //private []user _taskUserAssigned;
    private _taskImportance _taskImportance;
    private _taskFrequency _taskFrequency;
    private _taskStatus _taskStatus;
    private int _taskThumbnail;



    public task( String taskName , String taskDescription  ) {
        this._taskId = _allTasksID++;
        this._taskName = taskName;
        this._taskDescription = taskDescription;
        this._taskImportance = new _taskImportance();
        this._taskFrequency = new _taskFrequency();
        this._taskStatus = new _taskStatus();
        if ( this._taskStatus.getTaskStatusByInt() == 0) this._taskThumbnail = 0;
        else if ( this._taskStatus.getTaskStatusByInt() == 1) this._taskThumbnail = 1;
        else if ( this._taskStatus.getTaskStatusByInt() == 2) this._taskThumbnail = 2;
        else {
            this._taskThumbnail=333;
            Log.i(LOG,"Problem with _taskThumbnail definition");
            System.out.println("Problem with _taskThumbnail definition");
        }


        //this._taskLocation = new Location();
        Log.i(LOG, "task was created with values : "+this.toString());
        System.out.println("task was created with values : "+this.toString());
    }

    public static int get_allTasksID() {
        return _allTasksID;
    }

    public static void set_allTasksID(int _allTasksID) {
        task._allTasksID = _allTasksID;
    }

    public String get_taskDescription() {
        return _taskDescription;
    }

    public void set_taskDescription(String _taskDescription) {
        this._taskDescription = _taskDescription;
    }

    public com.example.tommyahav.androidfinal._taskFrequency get_taskFrequency() {
        return _taskFrequency;
    }

    public void set_taskFrequency(com.example.tommyahav.androidfinal._taskFrequency _taskFrequency) {
        this._taskFrequency = _taskFrequency;
    }

    public int get_taskId() {
        return _taskId;
    }

    public void set_taskId(int _taskId) {
        this._taskId = _taskId;
    }

    public com.example.tommyahav.androidfinal._taskImportance get_taskImportance() {
        return _taskImportance;
    }

    public void set_taskImportance(com.example.tommyahav.androidfinal._taskImportance _taskImportance) {
        this._taskImportance = _taskImportance;
    }

    public String get_taskName() {
        return _taskName;
    }

    public void set_taskName(String _taskName) {
        this._taskName = _taskName;
    }

    public com.example.tommyahav.androidfinal._taskStatus get_taskStatus() {
        return _taskStatus;
    }

    public void set_taskStatus(com.example.tommyahav.androidfinal._taskStatus _taskStatus) {
        this._taskStatus = _taskStatus;
    }

    public int get_taskThumbnail() {
        return _taskThumbnail;
    }

    public void set_taskThumbnail(int _taskThumbnail) {
        this._taskThumbnail = _taskThumbnail;
    }
}

class _taskImportance {
    private boolean important = false;
    private boolean normal = true;
    private boolean low = false;

    public _taskImportance(){
        this.important = this.low = false;
        this.normal = true;
    }

    void setImportant( int num ){
        if (num==0) { this.important=this.normal=false; this.low=true;}
        else if (num==1) { this.important=this.low=false; this.normal=true;}
        else if (num==2) { this.low=this.normal=false; this.important=true;}
        else { this.important=this.low=false; this.normal=true;
            System.out.println("setImportant failed , importance set to normal");
        }
    }

    public String getImportanceByString(){
        if (this.important==true && this.normal==this.low==false ) return "Important";
        else if (this.low==true && this.normal==this.important==false ) return "Low";
        else if (this.normal==true && this.low==this.important==false) return "Normal";
        else return "Problem with Importance of this task!!";
    }

    public boolean isImportant() {
        return important;
    }

    public boolean isLow() {
        return low;
    }

    public boolean isNormal() {
        return normal;
    }
}

class _taskFrequency {
    //private static final String LOG_taskImportance = "_taskImportance";

    private boolean daily = false;
    private boolean weekly = true;
    private boolean monthly = false;

    public _taskFrequency(){}

    void setFrequency( int num ){
        if (num==0) { this.weekly=this.monthly=false; this.daily=true;}
        else if (num==1) { this.daily=this.monthly=false; this.weekly=true;}
        else if (num==2) { this.daily=this.weekly=false; this.monthly=true;}
        else { this.daily=this.monthly=false; this.weekly=true;
            System.out.println("setFrequency failed , Frequency set to weekly");
            //Log.i(LOG, "setFrequency failed , Frequency set to weekly");
        }
    }

    public String getFrequencyByString(){
        if (this.daily==true && this.weekly==this.monthly==false ) return "Daily";
        else if (this.weekly==true && this.daily==this.monthly==false ) return "Weekly";
        else if (this.monthly==true && this.daily==this.weekly==false) return "Monthly";
        else return "Problem with _taskFrequency of this task!!";
    }



}

class _taskStatus{
    private boolean pending = true;
    private boolean active = false;
    private boolean complete = false;

    public _taskStatus(){}

    void setStatus( int num ){
        if (num==0) { this.active=this.complete=false; this.pending=true;}
        else if (num==1) { this.pending=this.complete=false; this.active=true;}
        else if (num==2) { this.pending=this.active=false; this.complete=true;}
        else { this.active=this.complete=false; this.pending=true;
            System.out.println("taskStatus failed , Status set to pending");
            //Log.i(LOG, "taskStatus failed , Status set to pending");
        }
    }

    public String getFrequencyByString(){
        if (this.pending==true && this.active==this.complete==false ) return "Pending";
        else if (this.active==true && this.pending==this.complete==false ) return "Active";
        else if (this.complete==true && this.pending==this.active==false) return "Complete";
        else {
            System.out.println("Problem with _taskStatus of this task!!");
            //Log.i(LOG, "getFrequencyByString() failed");
            return "Problem with _taskStatus of this task!!";
        }
    }

    public int getTaskStatusByInt(){
        if (this.pending==true) return 0;
        else if ( this.active==true) return 1;
        else if (this.complete==true) return 2;
        else {
            System.out.println("Problem with getTaskStatusByInt of this task!!");
            return 0;
        }
    }

}
