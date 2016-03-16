package com.example.tommyahav.androidfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TomGoldberg on 14.3.16.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    public static int allTasksNum = 500;
    public static int allUsersNum = 400;
    private static final String LOG = "(LOG)taskDB";
    SQLiteDatabase db;
    private static final String DB_NAME = "TaskerDataBase6.db";

    private static final String TASK_TABLE = "AllTasks6";
    private static final String _objectID = "objectId",
                                 _taskID = "taskID",
                                _taskName = "taskName",
                                _createdAt = "createdAt",
                                _taskDescription = "taskDescription",
                                _taskImportance = "taskImportance",
                                _taskFrequency = "taskFrequency",
                                _taskStatus = "taskStatus",
                                _taskLocation = "taskLocation",
                                _taskAssinedTo = "taskAssinedTo";

    private static final String sql_forTasks =
            "create table "+TASK_TABLE+" ("
                    + _taskID + " TEXT PRIMARY KEY,"
                    + _objectID + " TEXT ,"
                    + _taskName + " TEXT ,"
                    + _taskDescription + " TEXT ,"
                    + _taskImportance + " TEXT ,"
                    + _taskFrequency + " TEXT ,"
                    + _taskStatus + " TEXT ,"
                    + _taskAssinedTo + " TEXT )";

    //-----

    private static final String USER_TABLE = "AllUsers6";
    private static final String _userID = "userID",
                                _username = "username",
                                _password = "password",
                                _email = "email",
                                _manager = "manager",
                                _groupname = "groupname",
                                _phone = "phone";

    private static final String sql_forUsers =
            "create table "+USER_TABLE+" ("
                    + _userID + " TEXT PRIMARY KEY ,"
                    + _username + " TEXT ,"
                    + _password + " TEXT ,"
                    + _email + " TEXT ,"
                    + _groupname + " TEXT , "
                    + _phone + " TEXT ,"
                    + _manager + " INTEGER )";

    @Override
    public void onCreate(SQLiteDatabase db) {
            //dropTable(db);
            db.execSQL(sql_forTasks);
            db.execSQL(sql_forUsers);
    }

    public DatabaseHelper(Context c) {
        super(c, DB_NAME, null, 5);
    }

    @Override
    public void onUpgrade( SQLiteDatabase db , int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TASK_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public void dropTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + TASK_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
    }


    public boolean insertRowToTasksLocalDB(String taskID , String taskName , String taskDescription , String taskImportance ,String taskFrequency , String taskStatus  ){
        ContentValues contentValues = new ContentValues();
        //contentValues.put(_taskID , allTasksNum);
        contentValues.put(_taskID,taskID );
        contentValues.put(_taskName,taskName );
        contentValues.put(_taskDescription,taskDescription );
        contentValues.put(_taskImportance, taskImportance);
        contentValues.put(_taskFrequency, taskFrequency);
        contentValues.put(_taskStatus, taskStatus);
        if (insertToTable( contentValues , TASK_TABLE )) return true;
        else return false;
    }

    public boolean insertRowToUsersLocalDB(String userID , String username , String password , String email ,String manager , String phone , String group ){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (userID!=null)contentValues.put(_userID,userID );
        if (username!=null)contentValues.put(_username,username );
        if (password!=null)contentValues.put(_password,password );
        if (email!=null)contentValues.put(_email, email);
        if (manager!=null)contentValues.put(_manager, manager);
        contentValues.put(_groupname , group);
        if (phone!=null)contentValues.put(_phone , phone);

        if ( insertToTable(contentValues , USER_TABLE) ) return true;
        else return false;
    }


    public boolean insertToTable(ContentValues contentValues , String TABLE){
        long userRowID = db.insert(TABLE , null , contentValues) ;
        if ( userRowID == -1   ) return false;
        else return true;
    }

    public Cursor getMaxID_fromUserTable(){
        SQLiteDatabase db_forMaxUSERid = this.getWritableDatabase();
        Cursor res = db_forMaxUSERid.rawQuery("  SELECT MAX(userID) FROM "+ USER_TABLE , null);
        return res;
    }

    public Cursor getMaxID_fromTasksTable(){
        SQLiteDatabase db_forMaxTASKid = this.getWritableDatabase();
        Cursor res = db_forMaxTASKid.rawQuery("  SELECT MAX(taskID) FROM "+TASK_TABLE , null);
        return res;
    }

    public Cursor getAllTasksToView(){
        SQLiteDatabase db_forAllTasks = this.getWritableDatabase();
        Cursor res = db_forAllTasks.rawQuery("  SELECT * FROM "+ TASK_TABLE , null);
        return res;
    }

//    public Cursor getAllTasks(){
//
//    }

    public Integer deleteTask_ByID( String id ){
        SQLiteDatabase db_forDeleteTask = this.getWritableDatabase();
        return db_forDeleteTask.delete(TASK_TABLE , "taskID = ?" , new String[] {id});
    }
}
