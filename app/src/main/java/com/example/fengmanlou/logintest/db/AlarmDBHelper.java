package com.example.fengmanlou.logintest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fengmanlou on 2015/5/3.
 */
public class AlarmDBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "userinfo.db";
        public static final int DATABASE_VERSION = 2;
    public static final String TABLE = "alarm";


    private static final String CREATE_ALARM_TABLE = "CREATE TABLE " + TABLE + " ("
            + AlarmColumn._ID + " integer primary key AUTOINCREMENT,"
            + AlarmColumn.ALARM_ID + " text UNIQUE ON CONFLICT REPLACE,"
            + AlarmColumn.ALARM_CALENDAR + " text,"
            + AlarmColumn.ALARM_CANCELABLE + " text,"
            + AlarmColumn.ALARM_TAG + " text,"
            + AlarmColumn.ALARM_AVAILABLE + " text,"
            + AlarmColumn.ALARM_RINGTONE + " text)";

    public AlarmDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ALARM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql=" DROP TABLE IF EXISTS "+TABLE;
        db.execSQL(sql);
        onCreate(db);
    }
}
